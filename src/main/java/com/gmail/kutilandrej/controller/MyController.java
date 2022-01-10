package com.gmail.kutilandrej.controller;

import com.gmail.kutilandrej.entity.Human;
import com.gmail.kutilandrej.exceptionHandler.NoSuchHumanException;
import com.gmail.kutilandrej.service.HumanService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {

  @Autowired
  private HumanService humanService;

  @GetMapping("/employees")
  public List<Human> showAllHuman() {
    return humanService.getAllHumans();
  }

  @GetMapping("/employees/{id}")
  public Human getHuman(@PathVariable int id) {
    Human human = humanService.getHuman(id);
    if (human == null) {
      throw new NoSuchHumanException("Human is not been!");
    }
    return human;
  }

  @PostMapping("/employees")
  public Human addHuman(@RequestBody Human human) {
    humanService.saveHuman(human);
    return human;
  }

  @PutMapping("/employees")
  public Human updateHuman(@RequestBody Human human) {
    humanService.saveHuman(human);
    return human;
  }

  @DeleteMapping("/employees/{id}")
  public String updateHuman(@PathVariable int id) {
    if(humanService.getHuman(id) == null) {
      throw new NoSuchHumanException("Cannot delete human who does not exist");
    }
    humanService.deleteHuman(id);
    return "Done!";
  }
}
