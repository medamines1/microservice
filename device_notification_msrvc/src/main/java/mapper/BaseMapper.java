package mapper;



import models.*;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;


public class BaseMapper {

    public static DevicetDto DevicetToDto(Device device){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(device, DevicetDto.class);
    }



    public static List<DevicetDto> DevicetToDto(List<Device> devices){
        ModelMapper modelMapper = new ModelMapper();
        List<DevicetDto> tmp = new ArrayList<>();
        for (Device e : devices)
            tmp.add(modelMapper.map(e, DevicetDto.class));
        return tmp;
    }



    public static Device DtoToWallet(DevicetDto deviceDto){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(deviceDto, Device.class);
    }


    public static NotificationDto NotiftToDto(Notification notification){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(notification, NotificationDto.class);
    }


    public static List<NotificationDto> NotiftToDto(List<Notification> notifications){
        ModelMapper modelMapper = new ModelMapper();
        List<NotificationDto> tmp = new ArrayList<>();
        for (Notification e : notifications)
            tmp.add(modelMapper.map(e, NotificationDto.class));
        return tmp;
    }

    public static Notification DtoToNotif(NotificationDto notificationDto){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(notificationDto, Notification.class);
    }

}