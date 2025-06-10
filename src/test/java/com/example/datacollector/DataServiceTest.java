import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.datacollector.model.DataRecord;
import com.example.datacollector.repository.DataRepository;
import com.example.datacollector.service.DataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class DataServiceTest {

    @InjectMocks
    private DataService dataService;

    @Mock
    private DataRepository dataRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllDataRecords() {
        DataRecord record1 = new DataRecord(1L, "Breed1", "Friendly", "USA");
        DataRecord record2 = new DataRecord(2L, "Breed2", "Aggressive", "UK");
        when(dataRepository.findAll()).thenReturn(Arrays.asList(record1, record2));

        List<DataRecord> records = dataService.getAllDataRecords();

        assertEquals(2, records.size());
        assertEquals("Breed1", records.get(0).getName());
        assertEquals("Breed2", records.get(1).getName());
    }

    @Test
    public void testGetDataRecordById() {
        DataRecord record = new DataRecord(1L, "Breed1", "Friendly", "USA");
        when(dataRepository.findById(1L)).thenReturn(Optional.of(record));

        Optional<DataRecord> foundRecord = dataService.getDataRecordById(1L);

        assertTrue(foundRecord.isPresent());
        assertEquals("Breed1", foundRecord.get().getName());
    }

    @Test
    public void testGetDataRecordById_NotFound() {
        when(dataRepository.findById(1L)).thenReturn(Optional.empty());

        Optional<DataRecord> foundRecord = dataService.getDataRecordById(1L);

        assertFalse(foundRecord.isPresent());
    }

    @Test
    public void testSaveDataRecord() {
        DataRecord record = new DataRecord(null, "Breed1", "Friendly", "USA");
        DataRecord savedRecord = new DataRecord(1L, "Breed1", "Friendly", "USA");
        when(dataRepository.save(record)).thenReturn(savedRecord);

        DataRecord result = dataService.saveDataRecord(record);

        assertEquals(1L, result.getId());
        assertEquals("Breed1", result.getName());
    }
}