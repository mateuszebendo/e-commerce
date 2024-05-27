package org.br.serratec.ecommerce.services;

import jakarta.transaction.Transactional;
import org.br.serratec.ecommerce.dtos.ProdutoDTO;
import org.br.serratec.ecommerce.entities.Imagem;
import org.br.serratec.ecommerce.repositories.ImagemRepository;
import org.br.serratec.ecommerce.entities.Produto;
import org.br.serratec.ecommerce.exceptions.EntidadeNotFoundException;
import org.br.serratec.ecommerce.repositories.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;

	@Autowired
	ModelMapper modelMapper;
	@Autowired
	private ImagemRepository imagemRepository;
	@Transactional
	public ProdutoDTO save(MultipartFile file, ProdutoDTO produtoDto) throws IOException {
		Produto produtoSalvo = new Produto();
		produtoSalvo.setNome(produtoDto.getNome());
		produtoSalvo.setQtdEstoque(produtoDto.getQtdEstoque());
		produtoSalvo.setDataCadastro(produtoDto.getDataCadastro());
		produtoSalvo.setValorUnitario(produtoDto.getValorUnitario());
		produtoSalvo.setCategoria(produtoDto.getCategoria());
		//CIRAR DTO DA IMAGEM
		Imagem imagem = new Imagem();
		imagem.setData(file.getBytes());
		imagem.setMimetype(file.getContentType());
		imagemRepository.save(imagem);
		produtoSalvo.setImagem(imagem);
		produtoRepository.save(produtoSalvo);
		ProdutoDTO produtoDtoSalvo = modelMapper.map(produtoSalvo, ProdutoDTO.class);
		return produtoDtoSalvo;
	}

	public ProdutoDTO update(ProdutoDTO produtoDto) throws IOException {
		Integer produtoId = produtoDto.getProdutoId();
		Produto produtoBanco = produtoRepository.findById(produtoId).orElseThrow(
                () -> new EntidadeNotFoundException("Não foi encontrado nenhum Produto com id " + produtoId));
		produtoBanco.setNome(produtoDto.getNome());
		produtoBanco.setQtdEstoque(produtoDto.getQtdEstoque());
		produtoBanco.setValorUnitario(produtoDto.getValorUnitario());
		produtoBanco.setCategoria(produtoDto.getCategoria());
		produtoRepository.saveAndFlush(modelMapper.map(produtoDto, Produto.class));
		ProdutoDTO produtoDtoSalvo = modelMapper.map(produtoBanco, ProdutoDTO.class);
		return produtoDtoSalvo;
	}

	public ProdutoDTO updateImagem(MultipartFile file, Integer produtoId) throws IOException {
		Produto produtoBanco = produtoRepository.findById(produtoId).orElseThrow(
				() -> new EntidadeNotFoundException("Não foi encontrado nenhum Produto com id " + produtoId));

		Imagem imagem = produtoBanco.getImagem();
		imagem.setData(file.getBytes());
		imagem.setMimetype(file.getContentType());
		imagemRepository.saveAndFlush(imagem);
		produtoBanco.setImagem(imagem);
		produtoBanco.getImagem().setData(file.getBytes());
		produtoBanco.getImagem().setMimetype(file.getContentType());

		produtoRepository.saveAndFlush(produtoBanco);
		ProdutoDTO produtoDtoSalvo = modelMapper.map(produtoBanco, ProdutoDTO.class);
		return produtoDtoSalvo;
	}

	public List<ProdutoDTO> findAll() {
		List<Produto> produtos = produtoRepository.findAll();
		if (produtos.isEmpty()) {
			throw new NoSuchElementException("Nenhum produto encontrado.");
		}
		List<ProdutoDTO> produtosDto = new ArrayList<>();
		for (Produto produto : produtos) {
			produtosDto.add(modelMapper.map(produto, ProdutoDTO.class));
		}
		return produtosDto;
	}

	public ProdutoDTO findById(Integer id) {
		Produto produto = produtoRepository.findById(id)
				.orElseThrow(() -> new EntidadeNotFoundException("Não foi encontrado nenhum Produto com Id " + id));
		ProdutoDTO produtoDtoEncontrado = modelMapper.map(produto, ProdutoDTO.class);
		return produtoDtoEncontrado;
	}

	public ProdutoDTO deleteById(Integer id) {
		Produto produto = produtoRepository.findById(id)
				.orElseThrow(() -> new EntidadeNotFoundException("Não foi encontrado nenhum Produto com Id " + id));
		ProdutoDTO produtoDtoDeleted = modelMapper.map(produto, ProdutoDTO.class);
		produtoRepository.delete(produto);
		return produtoDtoDeleted;
	}

	public Imagem getImagem(Integer id) {
		Produto produto = produtoRepository.findById(id)
				.orElseThrow(() -> new EntidadeNotFoundException("Não foi encontrado nenhum Produto com Id " + id));
		return produto.getImagem();
	}
}