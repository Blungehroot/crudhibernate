import com.crudhibernate.app.model.Label;
import com.crudhibernate.app.repository.postgresrepository.LabelRepositoryImpl;
import com.crudhibernate.app.service.serviceimpl.LabelServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LabelServiceTest {

    @Mock
    private LabelRepositoryImpl labelRepository;

    @InjectMocks
    private LabelServiceImpl labelService;

    @Test
    void saveLabel_shouldBeSuccess() {
        Label label = new Label();
        label.setId(1);
        label.setName("Test label");

        when(labelRepository.save(label)).thenReturn(label);

        Label labelActual = labelService.save(label);

        assertNotNull(labelActual);
        assertEquals(label, labelActual);

        verify(labelRepository).save(ArgumentMatchers.eq(label));
    }

    @Test
    void deleteLabel_shouldBeSuccess() {
        Label label = new Label();
        label.setId(1);
        label.setName("Test label");

        doNothing().when(labelRepository).deleteById(label.getId());

        labelService.deleteById(label.getId());

        verify(labelRepository).deleteById(label.getId());
    }

    @Test
    void updateLabel_shouldBeSuccess() {
        Label labelExist = new Label();
        Label labelUpdated = new Label();

        labelExist.setId(1);
        labelExist.setName("Test label");

        labelUpdated.setName("Updated");
        labelUpdated.setId(1);

        lenient().when(labelRepository.save(labelExist)).thenReturn(labelExist);
        lenient().when(labelRepository.update(labelUpdated)).thenReturn(labelUpdated);

        Label result = labelService.update(labelUpdated);

        assertNotNull(result);
        assertNotEquals(labelExist.getName(), result.getName());

        verify(labelRepository).update(labelUpdated);
    }

    @Test
    void getLabelById_shouldBeSuccess() {
        Label label = new Label();
        label.setId(1);
        label.setName("Test label");

        when(labelRepository.getById(label.getId())).thenReturn(label);

        Label result = labelService.getById(label.getId());

        assertNotNull(result);
        assertEquals(label, result);

        verify(labelRepository).getById(label.getId());
    }

    @Test
    void getAll_shouldBeSuccess() {
        Label label = new Label();
        label.setId(1);
        label.setName("Test label");

        List<Label> labels = new ArrayList<>();
        labels.add(label);

        when(labelRepository.getAll()).thenReturn(labels);

        assertEquals(labels, labelService.getAll());

        verify(labelRepository).getAll();
    }
}
