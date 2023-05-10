package io.playdata.diary.service;

import io.playdata.diary.model.Diary;
import io.playdata.diary.repository.DiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class DiaryService {
    @Autowired
    private DiaryRepository diaryRepository;

    /**
     * 새로운 다이어리를 생성한다.
     *
     * @param diary 생성할 다이어리의 정보
     * @return 생성된 다이어리
     */
    public Diary createDiary(Diary diary) {
        diary.setCreateAt(LocalDateTime.now()); // 생성시의 시간 입력
        return diaryRepository.save(diary);
    }

    /**
     * ID에 해당하는 다이어리를 조회한다.
     *
     * @param id 조회할 다이어리의 ID
     * @return 조회된 다이어리, 없으면 null
     */
    public Diary getDiary(Long id) {
        return diaryRepository.findById(id).orElse(null);
    }

    /**
     * 모든 다이어리를 조회한다.
     *
     * @return 조회된 다이어리 목록
     */
    public List<Diary> getAllDiaries() {
        return diaryRepository.findAll();
    }

    /**
     * ID에 해당하는 다이어리를 삭제한다.
     *
     * @param id 삭제할 다이어리의 ID
     */
    public void deleteDiary(Long id) {
        diaryRepository.deleteById(id);
    }

    /**
     * ID에 해당하는 다이어리의 정보를 변경한다.
     *
     * @param id 변경할 다이어리의 ID
     * @param newDiary 변경할 다이어리의 정보
     * @return 변경된 다이어리
     */
    public Diary updateDiary(Long id, Diary newDiary) {
        Diary diary = diaryRepository.findById(id).orElse(null);
        if (diary == null) {
            return null;
        }
        diary.setTitle(newDiary.getTitle());
        diary.setContent(newDiary.getContent());
        diary.setImage(newDiary.getImage());
        diary.setSound(newDiary.getSound());
//        diary.setCreateAt(newDiary.getCreateAt());
        diary.setCreateAt(diary.getCreateAt());
        return diaryRepository.save(diary);
    }
}
