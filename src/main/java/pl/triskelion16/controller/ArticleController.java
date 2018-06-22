package pl.triskelion16.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.triskelion16.entity.Article;
import pl.triskelion16.entity.Author;
import pl.triskelion16.entity.Category;
import pl.triskelion16.repository.ArticleRepository;
import pl.triskelion16.repository.AuthorRepository;
import pl.triskelion16.repository.CategoryRepository;

@Controller
@RequestMapping("/article")
public class ArticleController {

	private ArticleRepository articleRepository;
	private AuthorRepository authorRepository;
	private CategoryRepository categoryRepository;

	@Autowired
	public ArticleController(ArticleRepository articleRepository, AuthorRepository authorRepository,
			CategoryRepository categoryRepository) {
		this.articleRepository = articleRepository;
		this.authorRepository = authorRepository;
		this.categoryRepository = categoryRepository;
	}
	
	@ModelAttribute("authors")
	public List<Author> getAuthors() {
		return authorRepository.findAll();
	}
	
	@ModelAttribute("categories")
	public List<Category> getCategories() {
		return categoryRepository.findAll();
	}

	/***** FIND *************************************************/
	@GetMapping("/list")
	public String listAll(Model model) {
		model.addAttribute("articles", articleRepository.findAll());
		return "article/list";
	}
	
	/***** ADD **********************************************/
	@GetMapping("/add")
	public String addForm(Model model) {
		model.addAttribute("articles", new Article());
		return "article/add";
	}
	
	@PostMapping("/add")
	public String save(@ModelAttribute Article article) {
		articleRepository.save(article);
		return "redirect:/article/list";
	}
}
