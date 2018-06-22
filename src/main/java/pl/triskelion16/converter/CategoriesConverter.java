package pl.triskelion16.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.triskelion16.entity.Category;
import pl.triskelion16.repository.CategoryRepository;

public class CategoriesConverter implements Converter<String, Category> {
	
	@Autowired
	private CategoryRepository categoryRepository;

	public Category convert(String source) {
		Category group = categoryRepository.findOne(Long.parseLong(source));
		return group;
	}
}
