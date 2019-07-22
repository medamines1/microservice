package mapper;



import models.CashIn;
import models.CashInDto;
import models.CashOut;
import models.CashOutDto;
import org.modelmapper.ModelMapper;


import java.util.ArrayList;
import java.util.List;


public class BaseMapper {

    public static CashInDto CAshIntToDto(CashIn device){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(device, CashInDto.class);
    }


    public static List<CashInDto> CAshIntToDto(List<CashIn> devices){
        ModelMapper modelMapper = new ModelMapper();
        List<CashInDto> tmp = new ArrayList<>();
        for (CashIn e : devices)
            tmp.add(modelMapper.map(e, CashInDto.class));
        return tmp;
    }



    public static CashIn DtoToCAshIn(CashInDto deviceDto){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(deviceDto, CashIn.class);
    }


    public static CashOutDto CashOutToDto(CashOut notification){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(notification, CashOutDto.class);
    }


    public static List<CashOutDto> CashOutToDto(List<CashOut> notifications){
        ModelMapper modelMapper = new ModelMapper();
        List<CashOutDto> tmp = new ArrayList<>();
        for (CashOut e : notifications)
            tmp.add(modelMapper.map(e, CashOutDto.class));
        return tmp;
    }

    public static CashOut DtoToCashOut(CashOutDto notificationDto){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(notificationDto, CashOut.class);
    }

}