import com.crudhibernate.app.model.Label;
import com.crudhibernate.app.model.Post;
import com.crudhibernate.app.model.Writer;
import com.crudhibernate.app.repository.WriterRepository;
import com.crudhibernate.app.service.serviceimpl.WriterServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class WriterServiceTest {

    @InjectMocks
    private WriterServiceImpl writerService;

    @Mock
    private WriterRepository writerRepository;


    @Test
    void saveWriter_shouldBeSuccess() {
        Label label = new Label();
        Post post = new Post();
        Writer writer = new Writer();
        List<Label> labels = new ArrayList<>();
        List<Post> posts = new ArrayList<>();

        label.setId(1);
        label.setName("Test label");
        labels.add(label);

        post.setId(1);
        post.setContent("Test content");
        post.setName("Test post");
        post.setLabels(labels);

        writer.setId(1);
        writer.setName("Test writer");
        writer.setPosts(posts);

        when(writerRepository.save(writer)).thenReturn(writer);

        Writer writerActual = writerRepository.save(writer);

        assertNotNull(writerActual);
        assertEquals(writer, writerActual);

        verify(writerRepository).save(writer);
    }

    @Test
    void deleteWriter_shouldBeSuccess() {
        Label label = new Label();
        Post post = new Post();
        Writer writer = new Writer();
        List<Label> labels = new ArrayList<>();
        List<Post> posts = new ArrayList<>();

        label.setId(1);
        label.setName("Test label");
        labels.add(label);

        post.setId(1);
        post.setContent("Test content");
        post.setName("Test post");
        post.setLabels(labels);

        writer.setId(1);
        writer.setName("Test writer");
        writer.setPosts(posts);

        doNothing().when(writerRepository).deleteById(writer.getId());

        writerRepository.deleteById(post.getId());

        verify(writerRepository).deleteById(writer.getId());
    }

    @Test
    void updateLabel_shouldBeSuccess() {
        Label label = new Label();
        Post post = new Post();
        Writer writerExist = new Writer();
        Writer writerUpdated = new Writer();
        List<Label> labels = new ArrayList<>();
        List<Post> posts = new ArrayList<>();

        label.setId(1);
        label.setName("Test label");
        labels.add(label);

        post.setId(1);
        post.setContent("Test content");
        post.setName("Test post");
        post.setLabels(labels);

        writerExist.setId(1);
        writerExist.setName("Test writer");
        writerExist.setPosts(posts);

        writerUpdated.setId(1);
        writerUpdated.setName("Test writer updated");
        writerUpdated.setPosts(posts);

        lenient().when(writerRepository.save(writerExist)).thenReturn(writerExist);
        lenient().when(writerRepository.update(writerUpdated)).thenReturn(writerUpdated);

        Writer result = writerRepository.update(writerUpdated);

        assertNotNull(result);
        assertNotEquals(writerExist.getName(), result.getName());

        verify(writerRepository).update(writerUpdated);
    }

    @Test
    void getWriterById_shouldBeSuccess() {
        Label label = new Label();
        Post post = new Post();
        Writer writer = new Writer();
        List<Label> labels = new ArrayList<>();
        List<Post> posts = new ArrayList<>();

        label.setId(1);
        label.setName("Test label");
        labels.add(label);

        post.setId(1);
        post.setContent("Test content");
        post.setName("Test post");
        post.setLabels(labels);

        writer.setId(1);
        writer.setName("Test writer");
        writer.setPosts(posts);

        when(writerRepository.getById(writer.getId())).thenReturn(writer);

        Writer result = writerRepository.getById(writer.getId());

        assertNotNull(result);
        assertEquals(writer, result);

        verify(writerRepository).getById(writer.getId());
    }

    @Test
    void getAll_shouldBeSuccess() {
        Label label = new Label();
        Post post = new Post();
        Writer writer = new Writer();
        List<Label> labels = new ArrayList<>();
        List<Post> posts = new ArrayList<>();
        List<Writer> writers = new ArrayList<>();

        label.setId(1);
        label.setName("Test label");
        labels.add(label);

        post.setId(1);
        post.setContent("Test content");
        post.setName("Test post");
        post.setLabels(labels);

        writer.setId(1);
        writer.setName("Test writer");
        writer.setPosts(posts);
        writers.add(writer);

        when(writerRepository.getAll()).thenReturn(writers);

        assertEquals(writers, writerRepository.getAll());

        verify(writerRepository).getAll();
    }
}
