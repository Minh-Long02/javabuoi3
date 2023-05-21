package javabuoi3.minhlong.serrvices;

import javabuoi3.minhlong.entity.Categogy;
import javabuoi3.minhlong.respository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;
    public List<Categogy> getAllCategories() { return categoryRepository.findAll();}
    public Categogy getCategoryById(Long id) { return categoryRepository.findById(id).orElse(null);}
    public Categogy saveCategogy (Categogy categogy) {return categoryRepository.save(categogy);}
    public void deleteCategogy(Long id) {categoryRepository.deleteById(id);}
}
