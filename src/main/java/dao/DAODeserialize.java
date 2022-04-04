package dao;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import source.HumanBeing;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Collections;

/**
 * Класс, который реализует десериализацию xml
 */
public class DAODeserialize {
    private HumanBeing[] humanBeings;
    @JsonProperty("Time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime initDate;

    public DAODeserialize() {}

    public ArrayDequeDAO deserialize() throws IOException {
        ArrayDequeDAO result = new ArrayDequeDAO();
        Collections.addAll(result.getHumanCollection(), humanBeings);
        result.setInitDate(initDate);
        return result;
    }

    public void setHumanBeings(HumanBeing[] humanBeings) {
        this.humanBeings = humanBeings;
    }

    public void setInitDate(LocalDateTime initDate) {
        this.initDate = initDate;
    }
}
