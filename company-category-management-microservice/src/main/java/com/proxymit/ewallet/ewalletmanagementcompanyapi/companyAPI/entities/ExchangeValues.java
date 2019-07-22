package com.proxymit.ewallet.ewalletmanagementcompanyapi.companyAPI.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExchangeValues {

    private List<Long> ids ;
    private int port ;
}
