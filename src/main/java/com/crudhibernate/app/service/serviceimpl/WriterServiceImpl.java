package com.crudhibernate.app.service.serviceimpl;

import com.crudhibernate.app.model.Writer;
import com.crudhibernate.app.repository.WriterRepository;
import com.crudhibernate.app.repository.postgresrepository.WriterRepositoryImpl;
import com.crudhibernate.app.service.WriterService;

import java.util.List;

public class WriterServiceImpl implements WriterService {
    private WriterRepositoryImpl writerRepositoryImpl;
    private WriterRepository writerRepository;

    public WriterServiceImpl() {
        this.writerRepositoryImpl = new WriterRepositoryImpl();
    }

    public WriterServiceImpl(WriterRepository writerRepository) {
        this.writerRepository = writerRepository;
    }

    @Override
    public Writer getById(int id) {
        return writerRepository.getById(id);
    }

    @Override
    public List<Writer> getAll() {
        return writerRepository.getAll();
    }

    @Override
    public Writer save(Writer writer) {
        return writerRepository.save(writer);
    }

    @Override
    public Writer update(Writer writer) {
        return writerRepository.update(writer);
    }

    @Override
    public void deleteById(int id) {
        writerRepository.deleteById(id);
    }
}
