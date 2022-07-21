package com.example.reCalculate;

import com.example.reCalculate.price.Context;
import lombok.Data;

@Data
public class Event {
    String scene;
    String type;
    String deduceType;
    Context context;
}
