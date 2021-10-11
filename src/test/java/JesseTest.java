import nl.hu.asd.team3.train.adapter.repository.TrainCompositionRepository;
import nl.hu.asd.team3.train.adapter.service.RollingStockRESTService;
import nl.hu.asd.team3.train.adapter.service.dto.inputRollingStockDTO;
import nl.hu.asd.team3.train.application.TrainCompositionService;
import nl.hu.asd.team3.train.application.exceptions.IdNotFoundException;
import nl.hu.asd.team3.train.domain.RollingStock;
import nl.hu.asd.team3.train.domain.TrainComposition;
import nl.hu.asd.team3.train.domain.exceptions.InvalidInputException;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;

public class JesseTest {
    private static TrainCompositionRepository repository;
    private static RollingStockRESTService restService;

    @BeforeClass
    public static void beforeClass() throws Exception{
        repository = mock(TrainCompositionRepository.class);

        when(repository.findById(123L)).thenReturn(java.util.Optional.of(new TrainComposition("stockType", 100)));

        restService = new RollingStockRESTService(new TrainCompositionService(repository));
    }

    @Test
    @DisplayName("Adds a rollingStock to a trainComposition")
    public void addRollingStockToTrainComposition(){
        TrainComposition trainComposition = new TrainComposition("testBrake", 123);

        inputRollingStockDTO goodinput = new inputRollingStockDTO();
        goodinput.position = 1;
        goodinput.stockType = "testStock";

        RollingStock r = new RollingStock(goodinput.position, goodinput.stockType);
        RollingStock trainRollStock = trainComposition.addRollingStockDTO(goodinput.position, goodinput.stockType);
        assertEquals(r.getPosition(), trainRollStock.getPosition());
        assertEquals(r.getStockType(), trainRollStock.getStockType());
    }

    @Test
    @DisplayName("Adds a rollingStock to a trainComposition")
    public void addRollingStockToRestService(){
        inputRollingStockDTO goodinput = new inputRollingStockDTO();
        goodinput.position = 1;
        goodinput.stockType = "testStock";

        TrainComposition t1 = restService.addRollingStock(123L, goodinput);
        TrainComposition t2 = new TrainComposition("stockType", 100);

        assertEquals(t1.getBrakeType(), t2.getBrakeType());
        assertEquals(t1.getLivestockOrPeopleIndicator(), t2.getLivestockOrPeopleIndicator());
    }

    @Test
    @DisplayName("gives a invalid trainCompositionId to the restService")
    public void addRollingStockWithInvalidTrainCompositionId(){
        inputRollingStockDTO goodinput = new inputRollingStockDTO();
        goodinput.position = 1;
        goodinput.stockType = "testStock";

        assertThrows(IdNotFoundException.class,
                () -> restService.addRollingStock(2L, goodinput));
    }

    @ParameterizedTest
    @MethodSource("provideRollingStockExamples")
    @DisplayName("Adds invalid RollingStockDTOs to a trainComposition")
    void addInvalidRollingStock(inputRollingStockDTO goodinput, inputRollingStockDTO i){
        System.out.println(i.position);
        TrainComposition trainComposition = new TrainComposition("testBrake", 123);
        trainComposition.addRollingStockDTO(goodinput.position, goodinput.stockType);
        assertThrows(InvalidInputException.class,
                () -> trainComposition.addRollingStockDTO(i.position, i.stockType));
    }

    private static Stream<Arguments> provideRollingStockExamples(){
        inputRollingStockDTO goodinput = new inputRollingStockDTO();
        goodinput.position = 1;
        goodinput.stockType = "testStock";

        inputRollingStockDTO i1 = new inputRollingStockDTO();
        inputRollingStockDTO i2 = new inputRollingStockDTO();
        i2.position = 2;
        inputRollingStockDTO i3 = new inputRollingStockDTO();
        i3.stockType = "testStock";
        inputRollingStockDTO i4 = new inputRollingStockDTO();
        i4.position = 1;
        i4.stockType = "testStock";
        return Stream.of(
                Arguments.of(goodinput, i1),
                Arguments.of(goodinput, i2),
                Arguments.of(goodinput, i3),
                Arguments.of(goodinput, i4)
        );
    }
}
