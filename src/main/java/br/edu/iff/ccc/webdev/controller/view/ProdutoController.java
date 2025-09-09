package br.edu.iff.ccc.webdev.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.iff.ccc.webdev.entities.Produto;
import br.edu.iff.ccc.webdev.exception.ProdutoNaoEncontrado;
import br.edu.iff.ccc.webdev.service.ProdutoService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping(path = "produtos")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping("/{id}")
    public String getHomePage(@PathVariable("id") Long id, Model model) {
                
        Produto produto;
        try {
            produto = produtoService.findProdutoById(id);
        } catch (ProdutoNaoEncontrado e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "produtos.html"; 
        }   
        model.addAttribute("produto", produto);
        return "produto.html";
        
    }
    
    @GetMapping()
    public String getAllProdutos(Model model) {
        model.addAttribute("produtos", produtoService.findAllProdutos());
        return "produtos.html"; // Return the view for displaying all products

    }

    @GetMapping("/new")
    public String createNewProduto(Model model) {
        model.addAttribute("produto", new Produto());
        return "produto_form.html"; // Return the form view for creating a new product
    }  
    
    @PostMapping()
    public String saveProduto(@Valid Produto produto, BindingResult error, Model model, RedirectAttributes redirectAttributes) {
        if (error.hasErrors()) {
            model.addAttribute("errorMessage", "Erro ao salvar o produto.");
            return "produto_form.html"; // Redirect to an error page if there are validation errors
        }
        
        produtoService.saveProduto(produto);
        // Injetamos para usar no redirect
        redirectAttributes.addFlashAttribute("successMessage", "Produto salvo com sucesso!");
        return "redirect:/produtos"; // Redirect to the products page after saving
    }

}
