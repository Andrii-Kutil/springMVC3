package com.gmail.kutilandrej.dao;

import com.gmail.kutilandrej.entity.Human;
import java.util.List;

public interface HumanDao {

  List<Human> getAllHumans();

  void saveHuman(Human human);

  Human getHuman(int id);

  void deleteHuman(int id);
}
