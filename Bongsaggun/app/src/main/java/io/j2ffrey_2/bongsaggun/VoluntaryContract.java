package io.j2ffrey_2.bongsaggun;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by han on 2015-10-28.
 */
public class VoluntaryContract {

    public static final String CONTENT_AUTHORITY = "io.j2ffrey_2.bongsaggun";

    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH_VOLUNTARY = "voluntary";
    public static final String PATH_IMAGE = "image";
    public static final String PATH_SCHOOL = "school";
    public static final String PATH_REGION = "region";

    //학교
    public static final class SchoolEntry implements BaseColumns {

        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_SCHOOL).build();

        public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_SCHOOL;
        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_SCHOOL;

        public static final String TABLE_NAME = "school";

        public static final String COLUMN_SCHOOL_ID = "school_id";  //INTEGER  지워도 될거 같은...

        public static final String COLUMN_SCHOOL_NAME = "school_name";  //TEXT

        public static Uri buildSchoolUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }

    //활동지역
    public static final class RegionEntry implements BaseColumns {

        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_REGION).build();

        public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_REGION;
        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_REGION;

        public static final String TABLE_NAME = "region";

        public static final String COLUMN_REGION_ID = "region_id";  //INTEGER  지워도 될거 같은...

        public static final String COLUMN_REGION_NAME = "region_name";  //TEXT

        public static Uri buildRegionUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }

    //이미지
    public static final class ImageEntry implements BaseColumns {

        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_IMAGE).build();

        public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_IMAGE;
        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_IMAGE;

        public static final String TABLE_NAME = "image";

        public static final String COLUMN_IMAGE_ID = "image_id";  //INTEGER  지워도 될거 같은...

        public static final String COLUMN_IMAGE_MAINBLOB = "image_mainBlob";  //BLOB
        public static final String COLUMN_IMAGE_POSTERBLOB = "image_posterBlob";  //BLOB

        public static Uri buildImageUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }

    //봉사정보
    public static final class VoluntaryEntry implements BaseColumns {

        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_VOLUNTARY).build();

        public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_VOLUNTARY;
        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_VOLUNTARY;

        public static final String TABLE_NAME = "voluntary";

        public static final String COLUMN_VOLUNTARY_ID = "voluntary_id";  //INTEGER  지워도 될거 같은...

        public static final String COLUMN_VOLUNTARY_CONTENT = "voluntary_content";  //TEXT  상세내용
        public static final String COLUMN_VOLUNTARY_DATERECRUITSTART = "voluntary_dateRecruitStart";  //TEXT  모집기간 시작
        public static final String COLUMN_VOLUNTARY_DATERECRUITEND = "voluntary_dateRecruitEnd";  //TEXT  모집기간 끝
        public static final String COLUMN_VOLUNTARY_DATESTART = "voluntary_dateStart";  //TEXT  봉사기간 시작
        public static final String COLUMN_VOLUNTARY_DATEEND = "voluntary_dateEnd";  //TEXT  봉사기간 끝
        public static final String COLUMN_VOLUNTARY_IMAGEID = "voluntary_mainImageId";  //INTEGER  이미지 id -> 이미지 테이블이랑 relationship
        public static final String COLUMN_VOLUNTARY_MAINIMAGEURL = "voluntary_mainImageURL";  //TEXT  메인 이미지 url -> 로딩용
        public static final String COLUMN_VOLUNTARY_POSTERIMAGEURL = "voluntary_posterImageURL";  //TEXT  포스터 이미지 url  -> 로딩용
        public static final String COLUMN_VOLUNTARY_PHONE = "voluntary_phone";  //TEXT  담당자 연락처
        public static final String COLUMN_VOLUNTARY_REGIONID = "voluntary_regioinId";  //INTEGER  활동지역 id
        public static final String COLUMN_VOLUNTARY_REQUIRE = "voluntary_require";  //TEXT  지원가능 조건
        public static final String COLUMN_VOLUNTARY_REQUIRESEX = "voluntary_requireSex";  //TEXT  지원가능 성별
        public static final String COLUMN_VOLUNTARY_SCHOOLID = "voluntary_schoolId";  //INTEGER  학교 id (검색시 사용)
        public static final String COLUMN_VOLUNTARY_TIME = "voluntary_time";  //TEXT  봉사시간
        public static final String COLUMN_VOLUNTARY_TITLE = "voluntary_title";  //TEXT  봉사제목
        public static final String COLUMN_VOLUNTARY_UPDATEAT = "voluntary_updateAt";  //TEXT  DB 업데이트 판

        public static Uri buildVoluntaryUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }
}
