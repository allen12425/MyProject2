package com.edward.proxy;

public class XiMenQing {
    public static void main(String[] args) {
        WangPo wangPo = new WangPo();
        wangPo.makeEyesWithMen();
        wangPo.playWithMen();

        JiaShi jiaShi = new JiaShi();
        WangPo wangPo2 = new WangPo(jiaShi);
        wangPo2.makeEyesWithMen();
        wangPo2.playWithMen();

    }
}
