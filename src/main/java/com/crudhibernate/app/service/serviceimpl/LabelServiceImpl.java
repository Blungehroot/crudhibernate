package com.crudhibernate.app.service.serviceimpl;

import com.crudhibernate.app.model.Label;
import com.crudhibernate.app.repository.postgresrepository.LabelRepositoryImpl;
import com.crudhibernate.app.service.LabelService;

import java.util.List;

public class LabelServiceImpl implements LabelService {
    private LabelRepositoryImpl labelRepositoryImpl;

    public LabelServiceImpl() {
        this.labelRepositoryImpl = new LabelRepositoryImpl();
    }

    public LabelServiceImpl(LabelRepositoryImpl labelRepositoryImpl) {
        this.labelRepositoryImpl = labelRepositoryImpl;
    }

    @Override
    public Label getById(int id) {
        return labelRepositoryImpl.getById(id);
    }

    @Override
    public List<Label> getAll() {
        return labelRepositoryImpl.getAll();
    }

    @Override
    public Label save(Label label) {
        return labelRepositoryImpl.save(label);
    }

    @Override
    public Label update(Label label) {
        return labelRepositoryImpl.update(label);
    }

    @Override
    public void deleteById(int id) {
        labelRepositoryImpl.deleteById(id);
    }
}
