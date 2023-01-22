package demo.project.rental.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse<T> implements Serializable {

    private static final Long serialVersionUID = 1L;
    /**
     * status
     */
    private String status;

    /**
     * Response Entity
     */
    private T data;
}
