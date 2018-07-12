package com.hero.util;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletRequest;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class PageData extends HashMap implements Map {

    private static final long serialVersionUID = 1L;

    Map map = null;
    HttpServletRequest request;

    public PageData(HttpServletRequest request) {
        this.request = request;
        Map properties = request.getParameterMap();
        Map returnMap = new HashMap();
        Iterator entries = properties.entrySet().iterator();
        Map.Entry entry;
        String name = "";
        String value = "";
        while (entries.hasNext()) {
            entry = (Map.Entry) entries.next();
            name = (String) entry.getKey();
            Object valueObj = entry.getValue();
            if (null == valueObj) {
                value = "";
            } else if (valueObj instanceof String[]) {
                String[] values = (String[]) valueObj;
                for (int i = 0; i < values.length; i++) {
                    value = values[i] + ",";
                }
                value = value.substring(0, value.length() - 1);
            } else {
                value = valueObj.toString();
            }
            if (name.equals("timeEnd")) {
                if (!value.equals("")) {
                    value = value + " 23:59:59";
                } else {

                }

            }
            returnMap.put(name, value);
        }
        map = returnMap;
    }

    public PageData(JSONObject jo) {
        Map returnMap = new HashMap();
        for (Iterator<String> keys = jo.keys(); keys.hasNext();) {
            try {
                String key1 = keys.next();
                // System.out.println("key1---" + key1 + "------" + jo.get(key1)
                // + (jo.get(key1) instanceof JSONObject)
                // + jo.get(key1) + (jo.get(key1) instanceof JSONArray));
                // System.out.println("key1:" + key1 + "----------jo.get(key1):"
                // + jo.get(key1));
                returnMap.put(key1.toUpperCase(), jo.get(key1));
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        map = returnMap;
    }

    public PageData() {
        map = new HashMap();
    }

    @Override
    public Object get(Object key) {
        Object obj = null;
        if (map.get(key) instanceof Object[]) {
            Object[] arr = (Object[]) map.get(key);
            obj = request == null ? arr : (request.getParameter((String) key) == null ? arr : arr[0]);
        } else {
            obj = map.get(key);
        }

        return obj;
    }

    public String getString(Object key) {
        // return String.valueOf(get(key)).toString();
        // System.out.println();
        // if(key instanceof String){
        // return (String) get(key);
        // } else if(key instanceof Integer){
        // return Integer.toString((int) key);
        // }
        // return (String) get(key);
        if (null != get(key) && "null" != get(key)) {
            return String.valueOf(get(key));
        }
        return "";
    }

    public double getDouble(Object key) {
        Object value = get(key);
        if (null != value && !"null".equals(value) && !"".equals(value)) {
            if (value instanceof String) {
                return Double.parseDouble(value.toString());
            } else if (value instanceof Double) {
                return (double) value;
            }
            // return (double) get(key);
        }
        return 0.0;
    }

    public int getInt(Object key) {
        Object value = get(key);
        if (null != value && !"null".equals(value) && !"".equals(value)) {
            if (value instanceof String) {
                return Integer.parseInt(value.toString());
            } else if (value instanceof Integer) {
                return (int) value;
            } else if (value instanceof Long) {
                return (int) value;
            }
        }
        return 0;
    }

    public long getLong(Object key) {
        Object value = get(key);
        if (null != value && !"null".equals(value) && !"".equals(value)) {
            if (value instanceof String) {
                return Integer.parseInt(value.toString());
            } else if (value instanceof Long) {
                return (long) value;
            }
        }
        return 0;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object put(Object key, Object value) {
        return map.put(key, value);
    }

    @Override
    public Object remove(Object key) {
        return map.remove(key);
    }

    public void clear() {
        map.clear();
    }

    public boolean containsKey(Object key) {
        // TODO Auto-generated method stub
        return map.containsKey(key);
    }

    public boolean containsValue(Object value) {
        // TODO Auto-generated method stub
        return map.containsValue(value);
    }

    public Set entrySet() {
        // TODO Auto-generated method stub
        return map.entrySet();
    }

    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return map.isEmpty();
    }

    public Set keySet() {
        // TODO Auto-generated method stub
        return map.keySet();
    }

    @SuppressWarnings("unchecked")
    public void putAll(Map t) {
        // TODO Auto-generated method stub
        map.putAll(t);
    }

    public int size() {
        // TODO Auto-generated method stub
        return map.size();
    }

    public Collection values() {
        // TODO Auto-generated method stub
        return map.values();
    }

    // 测试用
    public static void print(PageData pd) {
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%" + pd.size()
                + "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        Iterator entries = pd.entrySet().iterator();
        Map.Entry entry;
        String name = "";
        String value = "";
        String printStr = "{";
        while (entries.hasNext()) {
            entry = (Map.Entry) entries.next();
            name = (String) entry.getKey();
            Object valueObj = entry.getValue();
            if (null == valueObj) {
                value = "";
            } else if (valueObj instanceof String[]) {
                String[] values = (String[]) valueObj;
                for (int i = 0; i < values.length; i++) {
                    value = values[i] + ",";
                }
                value = value.substring(0, value.length() - 1);
            } else {
                value = valueObj.toString();
            }
            printStr += name + ":" + value + ",";
        }

        printStr += "}";

        System.out.println("PD::::::::" + printStr);
    }

}
