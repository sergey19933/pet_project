package com.serg.blog.controller;

import com.serg.blog.models.ProgramCatalog;
import com.serg.blog.repo.ProgramCatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class ProgramCatalogController {

    @Autowired
    private ProgramCatalogRepository programCatalogRepository;

    @GetMapping("/program_catalog")
    public String programCatalog(Model model) {
        Iterable<ProgramCatalog> programCatalog = programCatalogRepository.findAll();
        model.addAttribute("programCatalog", programCatalog);
        return "program_catalog-main";
    }

    @GetMapping("/program_catalog/add")
    public String programCatalogAdd(Model model) {
        return "program_catalog-add";
    }


    @PostMapping("/program_catalog/add")
    public String programCatalogAdd(@RequestParam String number,
                                    @RequestParam String nameProgram,
                                    Model model) {
        ProgramCatalog programCatalog = new ProgramCatalog(number, nameProgram);
        programCatalogRepository.save(programCatalog);//в таблицу прог будет добавляться названия прог
        return "redirect:/program_catalog";// переадресация
    }


    @GetMapping("/program_catalog/{id}")
    public String programCatalogDetails(@PathVariable(value = "id") long id, Model model) {
        if (!programCatalogRepository.existsById(id)) {
            return "redirect:/program_catalog";// переадресация
        }
        Optional<ProgramCatalog> programCatalog = programCatalogRepository.findById(id);
        ArrayList<ProgramCatalog> res = new ArrayList<>();
        programCatalog.ifPresent(res::add);
        model.addAttribute("programCatal", res);
        return "program_catalog-details";// шаблон
    }

    @GetMapping("/program_catalog/{id}/edit")
    public String programCatalogEdit(@PathVariable(value = "id") long id, Model model) {
        if (!programCatalogRepository.existsById(id)) {
            return "redirect:/program_catalog";// переадресация
        }
        Optional<ProgramCatalog> programCatalog = programCatalogRepository.findById(id);
        ArrayList<ProgramCatalog> res = new ArrayList<>();
        programCatalog.ifPresent(res::add);
        model.addAttribute("programCatal", res);
        return "program_catalog-edit";// шаблон
    }


    @PostMapping("/program_catalog/{id}/edit")
    public String programCatalogUpdate(@PathVariable(value = "id") long id,
                                       @RequestParam String number,
                                       @RequestParam String nameProgram,
                                       Model model) {
        ProgramCatalog programCatalog = programCatalogRepository.findById(id).orElseThrow();// orElseThrow() исключение если запись не найдена
        programCatalog.setNumber(number);
        programCatalog.setNameProgram(nameProgram);
        programCatalogRepository.save(programCatalog);//в таблицу прог будет добавляться названия прог
        return "redirect:/program_catalog";// переадресация
    }

    @PostMapping("/program_catalog/{id}/remove")
    public String programCatalogRemove(@PathVariable(value = "id") long id,
                                       Model model) {
        ProgramCatalog programCatalog = programCatalogRepository.findById(id).orElseThrow();// orElseThrow() исключение если запись не найдена
        programCatalogRepository.delete(programCatalog);//удалить номер программу
        return "redirect:/program_catalog";// переадресация
    }

}
