package com.saalim.rest.dao;

import com.saalim.rest.model.Item;
import org.springframework.stereotype.Repository;
import com.saalim.rest.model.Items;

import java.util.Objects;

@Repository
public class Dao {
    private static Items list = new Items();

    static {
        list.getItemList().add(
                new Item(
                        "0",
                        "iPhone 14 PRO MAX",
                        """
                                Item Details:
                                It's available in four different colours Space Black, Silver, Gold, Deep and Purple. It has Ceramic Shield front
                                Textured matt glass back and
                                stainless steel design. The iPhone 14 Pro Max display has rounded corners that follow a beautiful curved design, and these corners are within a standard rectangle. When measured as a standard rectangular shape, the screen is 6.69 inches diagonally (actual viewable area is less). It has the new Dynamic Island.""",
                        2100.99));
        list.getItemList().add(
                new Item(
                        "1",
                        "Apple AirPods Pro (2nd Generation)",
                        """
                                Item Details:
                                The new Apple‑designed H2 chip is the force behind AirPods Pro and its advanced audio performance. It works in concert with a custom‑built driver and amplifier to deliver crisp, clear high notes and deep, rich bass in stunning definition — so every sound is more vivid than ever. Noise-cancelling microphones and a rear vent are optimally placed to quickly detect sound coming in, working together to counter noise before it reaches your ear.""",
                        349.90));
        list.getItemList().add(
                new Item(
                        "2",
                        "Apple Watch Ultra",
                        """
                                Item Details:
                                To build the ultimate sports watch, we crafted every element with painstaking attention to detail for unparalleled performance. Titanium strikes the perfect balance between weight, ruggedness and corrosion resistance. The new case design rises up to surround the flat sapphire crystal and protect it from edge impacts. The Digital Crown is larger and the side button is raised from the case, making them easier to use while you’re wearing gloves.""",
                        599.99));
        list.getItemList().add(
                new Item(
                        "3",
                        "Macbook Pro M2",
                        """
                                Item Details:
                                M2 is the next generation of Apple silicon. Its 8-core CPU lets you zip through everyday tasks like creating documents and presentations, or take on more intensive workflows like developing in Xcode or mixing tracks in Logic Pro. M2 features up to a 10-core GPU, resulting in a big boost in graphics performance. And its media engine lets you play and edit up to 11 streams of 4K and up to two streams of 8K ProRes video.⁴""",
                        1099.99));
        list.getItemList().add(
                new Item(
                        "4",
                        "Apple iPhone 14",
                        """
                                About this item:
                                iPhone 14 comes with different colors like Midnight, Purple, Starlight, Product RED and Blue. It has Ceramic Shield front
                                Glass back and aluminium design. The iPhone 14 display has rounded corners that follow a beautiful curved design, and these corners are within a standard rectangle. When measured as a standard rectangular shape, the screen is 6.06 inches diagonally (actual viewable area is less).""",
                        899.99));
    }

    public static Items getItemsList() {
        return list;
    }

    public static void addItem(Item item) {
        list.getItemList().add(item);
    }

    public Item updateItem(String id, Item data) {
        Item item = null;
        int flag = 0;

        for (int i = 0; i < list.getItemList().size() && flag == 0; ++i) {
            if (Objects.equals(list.getItemList().get(i).getId(), id)) {
                item = list.getItemList().get(i);
                flag = 1;
            }

            if (flag == 1) {
                if (data.getId() != null)
                    item.setId(data.getId());

                if (data.getName() != null)
                    item.setName(data.getName());

                if (data.getDesc() != null)
                    item.setDesc(data.getDesc());

                if (data.getPrice() != 0.0)
                    item.setPrice(data.getPrice());
            }
        }
        return item;
    }

    public Item deleteItem(String id) {
        Item item = null;
        int flag = 0;

        for (int i = 0; i < list.getItemList().size() && flag == 0; ++i)
            if (Objects.equals(list.getItemList().get(i).getId(), id)) {
                item = new Item(list.getItemList().get(i));
                flag = 1;
                list.getItemList().remove(i);
            }

        return item;
    }
}
