package company.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PublishedEntity {
    private String message;
    private int index;
}
