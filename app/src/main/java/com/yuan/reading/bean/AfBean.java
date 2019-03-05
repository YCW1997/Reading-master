package com.yuan.reading.bean;

import java.util.List;

/**
 * Created by Administrator on 2019/3/2 0002.
 */

public class AfBean {

        private int curPage;
        private int offset;
        private boolean over;
        private int pageCount;
        private int size;
        private int total;
        private List<String> datas;

        public int getCurPage() {
                return curPage;
        }

        public void setCurPage(int curPage) {
                this.curPage = curPage;
        }

        public int getOffset() {
                return offset;
        }

        public void setOffset(int offset) {
                this.offset = offset;
        }

        public boolean isOver() {
                return over;
        }

        public void setOver(boolean over) {
                this.over = over;
        }

        public int getPageCount() {
                return pageCount;
        }

        public void setPageCount(int pageCount) {
                this.pageCount = pageCount;
        }

        public int getSize() {
                return size;
        }

        public void setSize(int size) {
                this.size = size;
        }

        public int getTotal() {
                return total;
        }

        public void setTotal(int total) {
                this.total = total;
        }

        public List<String> getDatas() {
                return datas;
        }

        public void setDatas(List<String> datas) {
                this.datas = datas;
        }
}
