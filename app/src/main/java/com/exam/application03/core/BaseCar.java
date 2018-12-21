package com.exam.application03.core;

import com.exam.application03.bean.Car;
import com.exam.application03.bean.Goods;
import com.exam.application03.bean.Page;

import java.util.List;

public interface BaseCar {
    void successpage(List<Car> car);
    void successpgoods(List<Goods> goods);
}
