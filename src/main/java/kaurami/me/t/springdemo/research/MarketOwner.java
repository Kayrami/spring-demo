package kaurami.me.t.springdemo.research;

import lombok.Data;

@Data
public class MarketOwner {
    String name;
    int marketCount;

    public MarketOwner(String name, int marketCount) {
        this.name = name;
        this.marketCount = marketCount;
    }
}
