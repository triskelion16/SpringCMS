package pl.triskelion16.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.triskelion16.entity.Author;
import pl.triskelion16.repository.AuthorRepository;

@Controller
@RequestMapping("/author")
public class AuthorController {

	private AuthorRepository authorRepository;

	@Autowired
	public AuthorController(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}
	
	/***** FIND *************************************************/
	@GetMapping("/list")
	public String listAll(Model model) {
		model.addAttribute("authors", authorRepository.findAll());
		return "author/list";
	}
	
	/***** ADD **********************************************/
	@GetMapping("/add")
	public String addForm(Model model) {
		model.addAttribute("authors", new Author());
		return "author/add";
	}
	
	@PostMapping("/add")
	public String save(@ModelAttribute Author author) {
		authorRepository.save(author);
		return "redirect:/author/list";
	}
	
	/***** UPDATE ************************************************/
	@GetMapping("/edit/{id}")
	public String update(@PathVariable long id, Model model) {
		model.addAttribute("authors", authorRepository.findOne(id));
		return "author/add";
	}
	
	@PostMapping("/edit/{id}")
	public String editForm(@ModelAttribute Author author) {
		authorRepository.save(author);
		return "redirect:/author/list";
	}
	
	/***** DELETE ********************************************/
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable long id) {
		authorRepository.delete(id);
		return "redirect:/author/list";
	}
}
