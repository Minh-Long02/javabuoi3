package javabuoi3.minhlong.serrvices;

import javabuoi3.minhlong.entity.Category;
import javabuoi3.minhlong.respository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;
    public List<Category> getAllCategories() { return categoryRepository.findAll();}
    public Category getCategoryById(Long id) { return categoryRepository.findById(id).orElse(null);}
    public Category saveCategogy (Category category) {return categoryRepository.save(category);}
    public void deleteCategogy(Long id) {categoryRepository.deleteById(id);}
}
