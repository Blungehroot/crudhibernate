package com.crudhibernate.app.controller;


import com.crudhibernate.app.model.Label;
import com.crudhibernate.app.service.LabelService;
import com.crudhibernate.app.service.serviceimpl.LabelServiceImpl;

import java.util.List;

public class LabelController {
    private final LabelService labelService;

    public LabelController() {
        labelService = new LabelServiceImpl();
    }

    public List<Label> getAll() {
        return labelService.getAll();
    }

    public Label getById(int id) {
        if (labelService.getById(id).getId() == null) {
            try {
                throw new Exception("Label with id = " + id + " is not present");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return labelService.getById(id);
    }

    public Label create(String name) {
        Label label = new Label();
        label.setName(name);
        return labelService.save(label);
    }

    public Label update(int id, String name) {
        if (labelService.getById(id).getId() == null) {
            try {
                throw new Exception("Label with id = " + id + " is not present and cannot be updated");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Label label = new Label();
        label.setId(id);
        label.setName(name);
        return labelService.update(label);
    }

    public void delete(int id) {
        if (labelService.getById(id).getId() == null) {
            try {
                throw new Exception("Label with id = " + id + " is not present and cannot be deleted");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        labelService.deleteById(id);
    }
}
