package com.proxymit.ewallet.ewalletmanagementprofiles.ProfileAPI.communication;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeValues {

    private List<Long> ids ;
    private int port ;
}
