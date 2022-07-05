package com.lwq;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.io.File;

public class functionTest {

    public static void main(String[] args) {
        File file = new File("D:\\desk\\tiffs");
        if(!file.exists()){
            return;
        }
        for (int i = 0; i < file.listFiles().length; i++) {
            File listFile = file.listFiles()[i];
            String fileName = getPinyin(listFile.getName().substring(0,listFile.getName().lastIndexOf(".")));
//            String ss = "INSERT INTO \"public\".\"dgis_layers\" (\"layer_uid\", \"layer_name\", \"layer_type\", \"layer_default_style\", \"layer_extent\", \"layer_wfs\", \"layer_wms\", \"maxfeature\", \"layer_modelid\", \"timecreated\", \"timemodified\", \"layer_datasource\", \"layer_datasource_uniqueid\", \"external_data_table_name\", \"layer_geom_field_name\", \"layer_cache\", \"layer_cache_time\") " +
//                    "VALUES " +
//                    "('9a6b4e0dbca44b01a0287134d4417"+(i+1)+"', '"+fileName+"', 'RASTER', 'e7d2e008689846a38a9afa578e2534f3', NULL, 't', 't', 100, NULL, NULL, NULL, 801, 435, '', 'geom', 'f', 0);";
//
//            System.out.println(ss);

//            System.out.println("INSERT INTO dgis_workspace_layer" +
//                    " " +
//                    "'2e82c274f15f49519c97d2c46028382b','9a6b4e0dbca44b01a0287134d4417"+(i+1)+"';");

            System.out.println("update dgis_layers set layer_extent = '"+
                    listFile.getName().substring(0,listFile.getName().lastIndexOf("."))
                    +"' where layer_name = '"+fileName+"';");


        }

    }


    /**
     * @param china (字符串 汉字)
     * @return 汉字转拼音 其它字符不变
     */
    public static String getPinyin(String china) {
        HanyuPinyinOutputFormat formart = new HanyuPinyinOutputFormat();
        formart.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        formart.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        formart.setVCharType(HanyuPinyinVCharType.WITH_V);
        char[] arrays = china.trim().toCharArray();
        String result = "";
        try {
            for (int i = 0; i < arrays.length; i++) {
                char ti = arrays[i];
                if (Character.toString(ti).matches("[\\u4e00-\\u9fa5]")) {
                    String[] temp = PinyinHelper.toHanyuPinyinStringArray(ti, formart);
                    result += temp[0];
                } else {
                    result += ti;
                }
            }
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            e.printStackTrace();
        }

        return result;
    }
}
