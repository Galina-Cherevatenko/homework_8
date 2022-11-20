package testing;
import org.example.homework_6.task_3.Main;
import org.junit.Assert;
import org.junit.Test;
import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class task_6_3_Test {
    @Test
    public void ListZoneTest (){
        // given

        ZonedDateTime time =  ZonedDateTime.now();
        String ZoneName = time.getZone().getId();


        //when
        List<ZonedDateTime> ListZoneResult = Main.ListZone(time);
        List<String> ListZoneString = new ArrayList<>();
        for(ZonedDateTime zone : ListZoneResult){
            ListZoneString.add(zone.getZone().getId());
        }

        // then
        Assert.assertTrue(!ListZoneString.contains(ZoneName));

    }

}
