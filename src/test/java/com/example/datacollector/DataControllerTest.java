import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.datacollector.controller.DataController;
import com.example.datacollector.model.DataRecord;
import com.example.datacollector.service.DataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

@WebMvcTest(DataController.class)
public class DataControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private DataService dataService;

    @InjectMocks
    private DataController dataController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllDataRecords() throws Exception {
        DataRecord record1 = new DataRecord(1L, "Breed1", "Friendly", "USA");
        DataRecord record2 = new DataRecord(2L, "Breed2", "Aggressive", "UK");
        List<DataRecord> records = Arrays.asList(record1, record2);

        when(dataService.getAllDataRecords()).thenReturn(records);

        mockMvc.perform(get("/api/data")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Breed1"))
                .andExpect(jsonPath("$[1].name").value("Breed2"));
    }

    @Test
    public void testGetDataRecordById() throws Exception {
        DataRecord record = new DataRecord(1L, "Breed1", "Friendly", "USA");

        when(dataService.getDataRecordById(1L)).thenReturn(record);

        mockMvc.perform(get("/api/data/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Breed1"));
    }

    @Test
    public void testCreateDataRecord() throws Exception {
        DataRecord newRecord = new DataRecord(null, "Breed3", "Calm", "Canada");

        when(dataService.createDataRecord(any(DataRecord.class))).thenReturn(new DataRecord(3L, "Breed3", "Calm", "Canada"));

        mockMvc.perform(post("/api/data")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Breed3\",\"temperament\":\"Calm\",\"origin\":\"Canada\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Breed3"));
    }
}