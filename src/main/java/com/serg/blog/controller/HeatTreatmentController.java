package com.serg.blog.controller;

import com.serg.blog.models.HeatTreatment;
import com.serg.blog.repo.HeatTreatmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class HeatTreatmentController {

    @Autowired
    private HeatTreatmentRepository heatTreatmentRepository;


    @GetMapping("/heat_treatment")
    public String heatTreatment(Model model) {
        Iterable<HeatTreatment> heatTr = heatTreatmentRepository.findAll();
        model.addAttribute("heatTr", heatTr);

        List<String> countDetail = heatTreatmentRepository.countDetail();
          int countDetails=countDetails(countDetail);// вызов метода по посчету деталей(сколько всего было сдано за все время)
          model.addAttribute("countDetail",countDetails);
        return "heat_treatment-main";
    }

    @GetMapping("/heat_treatment/add")
    public String heatTreatmentAdd(Model model) {
        return "heat_treatment-add";// шаблон
    }

    @PostMapping("/heat_treatment/add")
    public String heatTreatmentAdd(@RequestParam String position, @RequestParam String requirement,
                                   @RequestParam String orderr,
                                   @RequestParam String size,
                                   @RequestParam int quantity, @RequestParam String gost,
                                   @RequestParam String hrc,
                                   @RequestParam String steel,
                                   @RequestParam String gone, Model model) //реквест тип строка получение из термо адд из поля тайтл
    {
        HeatTreatment heatTreatment = new HeatTreatment(position, requirement, orderr, size, quantity, gost, hrc, steel, gone);
        heatTreatmentRepository.save(heatTreatment);//в таблицу термо будет добавляться новая статья
        return "redirect:/heat_treatment";// переадресация
    }

    @GetMapping("/heat_treatment/{id}")
    public String heatTreatmentDetails(@PathVariable(value = "id") long id, Model model) {
        if (!heatTreatmentRepository.existsById(id)) {
            return "redirect:/heat_treatment";// переадресация
        }
        Optional<HeatTreatment> heatTreatment = heatTreatmentRepository.findById(id);
        ArrayList<HeatTreatment> res = new ArrayList<>();
        heatTreatment.ifPresent(res::add);
        model.addAttribute("heatTreatment", res);
        return "heat_treatment-details";// шаблон
    }

    @GetMapping("/heat_treatment/{id}/edit")
    public String heatTreatmentEdit(@PathVariable(value = "id") long id, Model model) {
        if (!heatTreatmentRepository.existsById(id)) {
            return "redirect:/heat_treatment";// переадресация
        }
        Optional<HeatTreatment> heatTreatment = heatTreatmentRepository.findById(id);
        ArrayList<HeatTreatment> res = new ArrayList<>();
        heatTreatment.ifPresent(res::add);
        model.addAttribute("heatTreatment", res);
        return "heat_treatment-edit";// шаблон
    }

    @PostMapping("/heat_treatment/{id}/edit")
    public String heatTreatmentUpdate(@PathVariable(value = "id") long id,
                                      @RequestParam String position,
                                      @RequestParam String requirement,
                                      @RequestParam String orderr,
                                      @RequestParam String size,
                                      @RequestParam int quantity,
                                      @RequestParam String gost,
                                      @RequestParam String hrc,
                                      @RequestParam String steel,
                                      @RequestParam String gone,
                                      Model model) //реквест тип строка получение из блог адд из поля тайтл
    {
        HeatTreatment heatTreatment = heatTreatmentRepository.findById(id).orElseThrow();// orElseThrow() исключение если запись не найдена
        heatTreatment.setPosition(position);
        heatTreatment.setRequirement(requirement);
        heatTreatment.setOrderr(orderr);
        heatTreatment.setSize(size);
        heatTreatment.setQuantity(quantity);
        heatTreatment.setGost(gost);
        heatTreatment.setHrc(hrc);
        heatTreatment.setSteel(steel);
        heatTreatment.setGone(gone);
        heatTreatmentRepository.save(heatTreatment);
        return "redirect:/heat_treatment";// переадресация
    }

    @PostMapping("/heat_treatment/{id}/remove")//удаление позиции
    public String heatTreatmentDelete(@PathVariable(value = "id") long id, Model model) {
        HeatTreatment heatTreatment = heatTreatmentRepository.findById(id).orElseThrow();// orElseThrow() исключение если запись не найдена
        heatTreatmentRepository.delete(heatTreatment);
        return "redirect:/heat_treatment";// переадресация
    }

private static int countDetails(List<String> countDetail){     //метод по подсчету деталей
        int count=countDetail.stream()
                .mapToInt(a-> Integer.parseInt(a))
                .sum();
    return count;
}

}
