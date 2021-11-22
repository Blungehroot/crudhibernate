package com.crudhibernate.app.service.serviceimpl;

import com.crudhibernate.app.model.Label;
import com.crudhibernate.app.repository.LabelRepository;
import com.crudhibernate.app.service.LabelService;

import java.util.List;

public class LabelServiceImpl implements LabelService {
    private LabelRepository labelRepository;

    public LabelServiceImpl() {}

    public LabelServiceImpl(LabelRepository labelRepository) {
        this.labelRepository = labelRepository;
    }

    @Override
    public Label getById(int id) {
        return labelRepository.getById(id);
    }

    @Override
    public List<Label> getAll() {
        return labelRepository.getAll();
    }

    @Override
    public Label save(Label label) {
        return labelRepository.save(label);
    }

    @Override
    public Label update(Label label) {
        return labelRepository.update(label);
    }

    @Override
    public void deleteById(int id) {
        labelRepository.deleteById(id);
    }
}
