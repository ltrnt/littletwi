package ru.ltrnt.littletwi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.ltrnt.littletwi.entity.Article;
import ru.ltrnt.littletwi.service.ArticleService;

@Controller
public class MainController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/")
    public String getAllArticles(Model model) {
        model.addAttribute("articles", articleService.getAllArticles());
        return "all-articles";
    }

    @GetMapping("/add")
    public String addArticleGet(Model model) {
        Article article = new Article();
        article.setId(0L);
        model.addAttribute("article", article);

        return "add-article";
    }

    @GetMapping("/article/{id}/edit")
    public String editArticleById(@PathVariable long id, Model model) {
        Article article = articleService.getArticleById(id);
        model.addAttribute("article", article);

        return "add-article";
    }

    @GetMapping("/article/{id}/delete")
    public String deleteArticleById(@PathVariable long id, Model model) {
        articleService.deleteById(id);

        return "redirect:/";
    }

    @PostMapping("/add")
    public String addArticlePost(@RequestParam long id, @RequestParam String title, @RequestParam String anons,
                                 @RequestParam String content, Model model) {
        if (id == 0) {
            articleService.saveArticle(new Article(title, anons, content));
        } else {
            articleService.saveArticle(new Article(id, title, anons, content));
        }

        return "redirect:/";
    }

    @GetMapping("/article/{id}")
    public String getArticleById(@PathVariable long id, Model model) {
        Article article = articleService.getArticleById(id);
        model.addAttribute("article", article);
        return "article-details";
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }
}
