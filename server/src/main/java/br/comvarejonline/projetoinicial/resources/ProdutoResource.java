package br.comvarejonline.projetoinicial.resources;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import br.comvarejonline.projetoinicial.domains.Produto;
import br.comvarejonline.projetoinicial.domains.handler.Erros;
import br.comvarejonline.projetoinicial.dtos.ProdutoDTO;
import br.comvarejonline.projetoinicial.estoque.entradas.EntradaProduto;
import br.comvarejonline.projetoinicial.estoque.entradas.EntradaProdutoRequest;
import br.comvarejonline.projetoinicial.estoque.entradas.EntradaProdutoResponse;
import br.comvarejonline.projetoinicial.estoque.saidas.SaidaProduto;
import br.comvarejonline.projetoinicial.estoque.saidas.SaidaProdutoRequest;
import br.comvarejonline.projetoinicial.estoque.saidas.SaidaProdutoResponse;
import br.comvarejonline.projetoinicial.repositories.ProdutoRepository;
import br.comvarejonline.projetoinicial.services.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoService service;
	
	@Autowired
	private ProdutoRepository repository;
	
	@Autowired
	private final EntityManager manager;
	
	public ProdutoResource(ProdutoRepository repository,EntityManager manager) {
        this.manager=manager;
        this.repository = repository;
       
    }
	
	
	@GetMapping(value="/{id}")
	public ResponseEntity<ProdutoDTO> findById(@PathVariable Long id){
		Produto obj = service.findById(id);
		return ResponseEntity.ok().body(new ProdutoDTO(obj));
		
	}
	//PEGA A QUANTIDADE DE PRODUTOS DISPONIVEIS POR ID
	@GetMapping(value="/quantidade/{id}")
	public ResponseEntity<Integer> findById2(@PathVariable Long id){
		 Integer quantidadeDisponivel= repository.findByQuantidadeProduto(id);
		return ResponseEntity.ok().body(quantidadeDisponivel);
		
	}
	
	@GetMapping
	public ResponseEntity<List<ProdutoDTO>> findAll(){
		List<Produto> list = service.findAll();
		List<ProdutoDTO> listDTO = list.stream().map(obj -> new ProdutoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	
	
	
	@PostMapping
	public ResponseEntity<ProdutoDTO> create(@RequestBody ProdutoDTO objDTO){
		Produto newObj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
	@PostMapping("/{id}/entradas")
    @Transactional
    public ResponseEntity<?> realizarEntrada(@RequestBody  EntradaProdutoRequest entrada,@PathVariable Long id, UriComponentsBuilder uriBuilder){
        Optional<Produto> produto= repository.findById(id);
        if(produto.isEmpty()){
            Erros error=new Erros("Produto", "Não existe cadastro deste produto");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
        EntradaProduto entradaProduto=entrada.toModelo(produto.get());
        manager.persist(entradaProduto);
        produto.get().adicionarEntrada(entradaProduto);
        URI uri=uriBuilder.path("/produtos/{id}/entradas/{idEntrada}").buildAndExpand(Map.of("id",produto.get().getId(),"idEntrada",entradaProduto.getId())).toUri();
        return ResponseEntity.created(uri).body(new EntradaProdutoResponse(entradaProduto));
    }
	
	@PostMapping("/{id}/saidas")
    @Transactional
    public ResponseEntity<?> realizarSaida(@RequestBody  SaidaProdutoRequest saida,@PathVariable Long id, UriComponentsBuilder uriBuilder){
        Optional<Produto> produto= repository.findById(id);
        if(produto.isEmpty()){
            Erros error=new Erros("Produto", "Não existe cadastro deste produto");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
        Integer quantidadeDisponivel= repository.findByQuantidadeProduto(id);
        if (saida.getQuantidade()>quantidadeDisponivel){
            Erros error=new Erros("quantidade","Quantidade deve ser menor ou igual a "+quantidadeDisponivel);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
        SaidaProduto saidaProduto=saida.toModelo(produto.get());
        manager.persist(saidaProduto);
        produto.get().adicionarSaida(saidaProduto);
        URI uri=uriBuilder.path("/produtos/{id}/saidas/{idSaida}").buildAndExpand(Map.of("id",produto.get().getId(),"idSaida",saidaProduto.getId())).toUri();
        return ResponseEntity.created(uri).body(new SaidaProdutoResponse(saidaProduto));
    }
	
}

	


