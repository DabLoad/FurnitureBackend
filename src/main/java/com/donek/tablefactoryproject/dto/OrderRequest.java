package com.donek.tablefactoryproject.dto;

import com.donek.tablefactoryproject.domain.OrderConfig;
import com.donek.tablefactoryproject.domain.OrderStatus;
import com.donek.tablefactoryproject.domain.TableConfig;
import lombok.Data;

@Data
public class OrderRequest {
    private OrderConfig orderConfig;
    private String price;
}
