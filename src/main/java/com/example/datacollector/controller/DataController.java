import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/data")
public class DataController {

    private final DataService dataService;

    @Autowired
    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping
    public ResponseEntity<List<DataRecord>> getAllData() {
        List<DataRecord> dataRecords = dataService.getAllData();
        return ResponseEntity.ok(dataRecords);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataRecord> getDataById(@PathVariable Long id) {
        DataRecord dataRecord = dataService.getDataById(id);
        return dataRecord != null ? ResponseEntity.ok(dataRecord) : ResponseEntity.notFound().build();
    }

    @GetMapping("/filter")
    public ResponseEntity<List<DataRecord>> filterData(@RequestParam(required = false) String temperament,
                                                       @RequestParam(required = false) String origin) {
        List<DataRecord> filteredData = dataService.filterData(temperament, origin);
        return ResponseEntity.ok(filteredData);
    }
}