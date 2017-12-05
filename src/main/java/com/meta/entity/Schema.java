package com.meta.entity;

/**
 * Created by cq
 * date: 11/16 0016 15:22
 */

import java.util.List;

/**
 * meta列
 */
public class Schema {
    String name;
    String display_name;
    String type;
    List   options;
    //TODO
//{
//    "list": {
//        "all": {
//            "options_value": [
//                    "已授信",
//                    "未授信"
//            ]
//        }
//    }
//}
    String object_name;
    String delete_option;
    String nullable;
    String index;
    String unique;
    String searchable;
    String related_type;



    String expression;
    String format;
    String start_number;
    String default_value;
    //TODO
//    {
//        "value": "main"
//    }
    String group;
    String readable;
    String writable;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List getOptions() {
        return options;
    }

    public void setOptions(List options) {
        this.options = options;
    }

    public String getObject_name() {
        return object_name;
    }

    public void setObject_name(String object_name) {
        this.object_name = object_name;
    }

    public String getDelete_option() {
        return delete_option;
    }

    public void setDelete_option(String delete_option) {
        this.delete_option = delete_option;
    }

    public String getNullable() {
        return nullable;
    }

    public void setNullable(String nullable) {
        this.nullable = nullable;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getUnique() {
        return unique;
    }

    public void setUnique(String unique) {
        this.unique = unique;
    }

    public String getSearchable() {
        return searchable;
    }

    public void setSearchable(String searchable) {
        this.searchable = searchable;
    }

    public String getRelated_type() {
        return related_type;
    }

    public void setRelated_type(String related_type) {
        this.related_type = related_type;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getStart_number() {
        return start_number;
    }

    public void setStart_number(String start_number) {
        this.start_number = start_number;
    }

    public String getDefault_value() {
        return default_value;
    }

    public void setDefault_value(String default_value) {
        this.default_value = default_value;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getReadable() {
        return readable;
    }

    public void setReadable(String readable) {
        this.readable = readable;
    }

    public String getWritable() {
        return writable;
    }

    public void setWritable(String writable) {
        this.writable = writable;
    }

    @Override
    public String toString() {
        return "Schema{" +
                "name='" + name + '\'' +
                ", display_name='" + display_name + '\'' +
                ", type='" + type + '\'' +
                ", options=" + options +
                ", object_name='" + object_name + '\'' +
                ", delete_option='" + delete_option + '\'' +
                ", nullable='" + nullable + '\'' +
                ", index='" + index + '\'' +
                ", unique='" + unique + '\'' +
                ", searchable='" + searchable + '\'' +
                ", related_type='" + related_type + '\'' +
                ", expression='" + expression + '\'' +
                ", format='" + format + '\'' +
                ", start_number='" + start_number + '\'' +
                ", default_value='" + default_value + '\'' +
                ", group='" + group + '\'' +
                ", readable='" + readable + '\'' +
                ", writable='" + writable + '\'' +
                '}';
    }
}
