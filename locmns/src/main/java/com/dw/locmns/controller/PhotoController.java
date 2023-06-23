package com.dw.locmns.controller;


import com.dw.locmns.dao.PhotoDao;
import com.dw.locmns.model.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class PhotoController {
    @Autowired
    private PhotoDao photoDao;


}
