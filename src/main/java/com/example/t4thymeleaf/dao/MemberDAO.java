package com.example.t4thymeleaf.dao;

import com.example.t4thymeleaf.model.MemberModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberDAO extends JpaRepository<MemberModel,Long> {


}
