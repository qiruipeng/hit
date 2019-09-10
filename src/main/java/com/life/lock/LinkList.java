package com.life.lock;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author: qirp
 * @since: 2019/9/7 17:59
 **/
@Slf4j
public class LinkList {

    @Data
    final class Node{
        int state;
        Node pre;
        Node next;
        public Node(int state, Node pre, Node next) {
            this.state = state;
            this.pre = pre;
            this.next = next;
        }
    }

    @Test
    public void test(){

    }
}
