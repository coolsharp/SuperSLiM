package com.tonicartos.superslimexample;

/**
 * Created by coolsharp on 2016-03-10.
 * 리스트에 표시할 데이터를 선언함
 */
public class Type {
    protected ViewType type;
    protected int sectionFirstPosition;
    protected boolean visible = true;

    /**
     * 데이터 종류는 4가지임
     * 스티키 헤더, 배송, 1뎊스, 2뎊스
     */
    public enum ViewType {
        vtHeader, vtShip, vtOne, vtTwo
    }

    public Type(ViewType type, int sectionFirstPosition) {
        this.type = type;
        this.sectionFirstPosition = sectionFirstPosition;
    }

    /**
     * 타입의 종류를 반환함
     * @return
     */
    public ViewType getType() {
        return type;
    }

    /**
     * 섹션 처음 위치
     * @return
     */
    public int getSectionFirstPosition() {
        return sectionFirstPosition;
    }

    /**
     * 섹션 처음 위치
     * @param sectionFirstPosition
     */
    public void setSectionFirstPosition(int sectionFirstPosition) {
        this.sectionFirstPosition = sectionFirstPosition;
    }

    /**
     * 접힘 펼침 상태 지정
     * @return
     */
    public boolean isVisible() {
        return visible;
    }

    /**
     * 접힘 펼침 상태 지정
     * @param isVisible
     */
    public void setVisible(boolean isVisible) {
        this.visible = isVisible;
    }
}
