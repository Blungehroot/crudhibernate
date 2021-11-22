package com.crudhibernate.app.service.serviceimpl;

import com.crudhibernate.app.model.Writer;
import com.crudhibernate.app.repository.postgresrepository.WriterRepositoryImpl;
import com.crudhibernate.app.service.WriterService;

import java.util.List;

public class WriterServiceImpl implements WriterService {
    private WriterRepositoryImpl writerRepositoryImpl;

    public WriterServiceImpl() {
        this.writerRepositoryImpl = new WriterRepositoryImpl();
    }

    @Override
    public Writer getById(int id) {
        return writerRepositoryImpl.getById(id);
    }

    @Override
    public List<Writer> getAll() {
        return writerRepositoryImpl.getAll();
    }

    @Override
    public Writer save(Writer writer) {
        return writerRepositoryImpl.save(writer);
    }

    @Override
    public Writer update(Writer writer) {
        return writerRepositoryImpl.update(writer);
    }

    @Override
    public void deleteById(int id) {
        writerRepositoryImpl.deleteById(id);
    }
}
