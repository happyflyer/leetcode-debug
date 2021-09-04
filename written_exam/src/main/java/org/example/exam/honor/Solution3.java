package org.example.exam.honor;

import java.util.*;

/**
 * 输入：
 * I MusicA Pop
 * I MusicB Pop
 * I MusicC Blue
 * I MusicD Blue
 * I MusicE UnkownStyle
 * I MusicF Pop
 * P MusicA
 * P MusicB
 * B MusicC
 * P MusicF
 * B MusicD
 * B MusicE
 * 输出：
 * MusicA Pop
 * MusicB Pop
 * MusicF Pop
 * MusicD Blue
 * MusicE UnkownStyle
 * MusicC Blue
 *
 * @author lifei
 */
public class Solution3 {
    private static final String SEP = " ";

    private static List<String> getAns(LinkedList<String> list) {
        Map<String, String> musicToCate = new HashMap<>();
        Map<String, List<String>> cateToMusics = new HashMap<>();
        Map<String, Integer> musicToFav = new HashMap<>();
        String prevPCate = "";
        String prevBCate = "";
        for (String s : list) {
            String[] arr = s.split(SEP);
            String type = arr[0];
            String music = arr[1];
            if ("I".equals(type)) {
                String cate = arr[2];
                // musicToCate
                musicToCate.put(music, cate);
                // cateToMusics
                List<String> musics = cateToMusics.getOrDefault(cate, new LinkedList<>());
                musics.add(music);
                cateToMusics.put(cate, musics);
                // musicFav
                musicToFav.put(music, musicToFav.getOrDefault(music, 0));
            } else if ("P".equals(type)) {
                musicToFav.put(music, musicToFav.get(music) + 3);
                if (!"UnkownStyle".equals(musicToCate.get(music))
                        && prevPCate.equals(musicToCate.get(music))) {
                    List<String> musics = cateToMusics.get(prevPCate);
                    for (String m : musics) {
                        if (!music.equals(m)) {
                            musicToFav.put(m, musicToFav.get(m) + 1);
                        }
                    }
                }
                prevPCate = musicToCate.get(music);
            } else if ("B".equals(type)) {
                musicToFav.put(music, musicToFav.get(music) - 2);
                if (!"UnkownStyle".equals(musicToCate.get(music))
                        && prevBCate.equals(musicToCate.get(music))) {
                    List<String> musics = cateToMusics.get(prevBCate);
                    for (String m : musics) {
                        if (!music.equals(m)) {
                            musicToFav.put(m, musicToFav.get(m) - 1);
                        }
                    }
                }
                prevBCate = musicToCate.get(music);
            }
        }
        // System.out.println(musicToCate);
        // System.out.println(cateToMusics);
        // System.out.println(musicToFav);
        Map<Integer, List<String>> favToMusic = new HashMap<>();
        LinkedList<Integer> favList = new LinkedList<>();
        LinkedList<String> ans = new LinkedList<>();
        for (Map.Entry<String, Integer> entry : musicToFav.entrySet()) {
            String music = entry.getKey();
            Integer fav = entry.getValue();
            if (!favToMusic.containsKey(fav)) {
                favToMusic.put(fav, new LinkedList<>());
            }
            List<String> musics = favToMusic.get(fav);
            musics.add(music);
            favToMusic.put(fav, musics);
            if (!favList.contains(fav)) {
                favList.add(fav);
            }
        }
        // System.out.println(favToMusic);
        Collections.sort(favList);
        // System.out.println(favList);
        while (!favList.isEmpty()) {
            Integer fav = favList.removeLast();
            List<String> musics = favToMusic.get(fav);
            Collections.sort(musics);
            for (String m : musics) {
                ans.add(m + " " + musicToCate.get(m));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<String> list = new LinkedList<>();
        while (true) {
            String data = sc.nextLine();
            if (data.isEmpty()) {
                break;
            }
            list.addLast(data);
        }
        for (String s : getAns(list)) {
            System.out.println(s);
        }
    }
}
