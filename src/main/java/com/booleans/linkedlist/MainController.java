package com.booleans.linkedlist;

import Lab.LinkedList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import java.util.Arrays;

@RequestMapping("")
@Controller
public class MainController
{
    @GetMapping("/")
    public String Index() {
        return "index";
    }

    @GetMapping("/linked-list")
    public String linkedlist(@RequestParam(value = "val1", required = false) Integer val1,
                             @RequestParam(value = "val2", required = false) Integer val2,
                             @RequestParam(value = "val3", required = false) Integer val3,
                             @RequestParam(value = "val4", required = false) Integer val4,
                             @RequestParam(value = "val5", required = false) Integer val5,
                             @RequestParam(value = "val6", required = false) Integer val6,
                             Model model)
    {
        Integer[] unsort = new Integer[]{val1, val2, val3, val4, val5, val6};

        if (val1 == null)
        {
            val1 = 0;
        }
        if (val2 == null)
        {
            val2 = 0;
        }
        if (val3 == null)
        {
            val3 = 0;
        }
        if (val4 == null)
        {
            val4 = 0;
        }
        if (val5 == null)
        {
            val5 = 0;
        }
        if (val6 == null)
        {
            val6 = 0;
        }


        LinkedList linkedsort = new LinkedList();

        linkedsort.addNode(val1);
        linkedsort.addNode(val2);
        linkedsort.addNode(val3);
        linkedsort.addNode(val4);
        linkedsort.addNode(val5);
        linkedsort.addNode(val6);

        LinkedList.Node n = linkedsort.head;
        while (n.next != null)
        {
            n = n.next;
        }

        linkedsort.sort(linkedsort.head, n);


        model.addAttribute("unsorted", Arrays.toString(unsort));
        model.addAttribute("sorted", Arrays.toString(linkedsort.printList(linkedsort.head)));


        return "linked-list";
    }
}