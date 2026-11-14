package com.siranting.siranting.utils

object Texts {

    fun appDescription(lang: String) =
        if (lang == "id")
            "Sistem Skrining Risiko Stunting untuk Ibu Hamil dan Balita" else "Stunting Risk Screening System for Pregnant Women and Toddlers"

    fun applicationBenefits(lang: String) =
        if (lang == "id") "Manfaat Aplikasi" else "Application Benefits"

    fun benefit1(lang: String) =
        if (lang == "id")
            "✓ Membantu Identifikasi Dini Risiko Stunting" else "✓ Helps Early Identification of Stunting Risk"

    fun benefit2(lang: String) =
        if (lang == "id")
            "✓ Mendukung Pemantauan Kesehatan Ibu dan Balita" else "✓ Supports Maternal and Child Health Monitoring"

    fun benefit3(lang: String) =
        if (lang == "id")
            "✓ Memberikan Hasil Skrining Secara Cepat dan Mudah" else "✓ Provides Fast and Easy Screening Results"

    fun howToUse(lang: String) =
        if (lang == "id") "Cara Penggunaan" else "How to Use"

    fun step1(lang: String) =
        if (lang == "id") "1. Login ke Aplikasi" else "1. Login to the Application"

    fun step2(lang: String) =
        if (lang == "id") "2. Pilih Layanan Skrining" else "2. Select the Screening Service"

    fun step3(lang: String) =
        if (lang == "id") "3. Isi Formulir Sesuai Kondisi" else "3. Fill Out the Form According to the Condition"

    fun step4(lang: String) =
        if (lang == "id") "4. Lihat Hasil Analisis Risiko" else "4. View the Risk Analysis Results"

    fun startNow(lang: String) =
        if (lang == "id") "MULAI SEKARANG" else "GET STARTED"

    fun back(lang: String) =
        if (lang == "id") "← Kembali" else "← Back"

    // ================= LOGIN =================
    fun loginTitle(lang: String) =
        if (lang == "id") "Masuk Akun" else "Sign In"

    fun username(lang: String) =
        if (lang == "id") "Username / No HP" else "Username / Phone Number"

    fun forgotPassword(lang: String) =
        if (lang == "id") "Lupa Password?" else "Forgot Password?"

    fun login(lang: String) =
        if (lang == "id") "MASUK" else "LOGIN"

    fun register(lang: String) =
        if (lang == "id") "Daftar" else "Regist"

    // ================= DASHBOARD =================
    fun welcome(lang: String) =
        if (lang == "id") "Selamat Datang 👋" else "Welcome 👋"

    fun dashboardDescription(lang: String) =
        if (lang == "id")
            "Pilih Layanan Yang Tersedia Untuk Melakukan Skrining Risiko Stunting Dan Mengakses Materi Edukasi Kesehatan."
        else
            "Choose Available Services For Stunting Risk Screening And Health Education Materials."

    fun pregnancyScreening(lang: String) =
        if (lang == "id") "Skrining Ibu Hamil" else "Pregnancy Screening"

    fun pregnancyDesc(lang: String) =
        if (lang == "id")
            "Analisis Faktor Risiko Stunting Selama Masa Kehamilan." else "Analyze Stunting Risk Factors During Pregnancy."

    fun childScreening(lang: String) =
        if (lang == "id") "Skrining Balita" else "Child Screening"

    fun childDesc(lang: String) =
        if (lang == "id")
            "Analisis Faktor Risiko Stunting Pada Balita." else "Analyze Stunting Risk Factors in Toddlers."

    fun education(lang: String) =
        if (lang == "id") "Edukasi Stunting" else "Stunting Education"

    fun educationDesc(lang: String) =
        if (lang == "id")
            "Video Pembelajaran dan Materi Edukasi Kesehatan." else "Learning Videos and Health Education Materials."

    fun systemName(lang: String) =
        if (lang == "id") "Sistem Skrining Medis" else "Medical Screening System"

    // ================= EDUCATION =================
    fun educationTitle(lang: String) =
        if (lang == "id") "Edukasi Stunting" else "Stunting Education"

    fun educationHeader(lang: String) =
        if (lang == "id") "Pusat Edukasi SIRANTING" else "SIRANTING Education Center"

    fun EDUeducationDesc(lang: String) =
        if (lang == "id")
            "Pelajari Informasi Mengenai Stunting Melalui Video Edukasi Kesehatan." else "Learn About Stunting Through Health Education Videos."

    fun watchNow(lang: String) =
        if (lang == "id") "TONTON SEKARANG" else "WATCH NOW"

    // ================= FORM IBU HAMIL =================
    fun judulibu(lang: String) =
        if (lang == "id") "Instrumen Skrining Risiko Ibu Hamil" else "Risk Screening Tool for Pregnant Women."

    fun dataibuumum(lang: String) =
        if (lang == "id") "👤 DATA UMUM IBU HAMIL" else "👤 GENERAL INFORMATION ON PREGNANT WOMEN"

    fun identitasibu(lang: String) =
        if (lang == "id") "1. Identitas Ibu" else "1. Identity of the Pregnant Woman"

    fun nama(lang: String) =
        if (lang == "id") "Nama" else "Name"

    fun usiamenikah(lang: String) =
        if (lang == "id") "Usia Menikah (Tahun)" else "Age at Marriage (Years)"

    fun usiakehamilan(lang: String) =
        if (lang == "id") "Usia Kehamilan (Minggu)" else "Gestational Age (Weeks)"

    fun jumlahanak(lang: String) =
        if (lang == "id") "Jumlah Anak" else "Number of Children"

    fun usiaibusaathamil(lang: String) =
        if (lang == "id") "Usia Ibu Saat Hamil" else "Mother's Age During Pregnancy"

    fun usia20_35(lang: String) =
        if (lang == "id") "20–35 Tahun" else "20–35 Years"

    fun usiaRiskEkstrem(lang: String) =
        if (lang == "id") "<20 atau >35 Tahun" else "<20 or >35 Years"

    fun pendidikanibu(lang: String) =
        if (lang == "id") "Pendidikan Ibu" else "Mothers' Education"

    fun pendidikanTinggi(lang: String) =
        if (lang == "id") "Pendidikan Tinggi" else "Higher Education"

    fun pendidikanSD_SMA(lang: String) =
        if (lang == "id") "SD–SMA" else "Primary–Secondary School"

    fun tidakTamatSD(lang: String) =
        if (lang == "id") "Tidak Tamat SD" else "Did Not Complete Primary School"

    fun pendapatankeluarga(lang: String) =
        if (lang == "id") "Pendapatan Keluarga" else "Family Income"

    fun pendapatanDiatasUMK(lang: String) =
        if (lang == "id") "Di Atas UMK (> Rp. 3.268.000)" else "Above Minimum Wage (> Rp. 3,268,000)"

    fun pendapatanDibawahUMK(lang: String) =
        if (lang == "id") "Di Bawah UMK (< Rp. 3.268.000)" else "Below Minimum Wage (< Rp. 3,268,000)"

    fun bukukia(lang: String) =
        if (lang == "id") "Memiliki Buku KIA" else "KIA Book"

    fun punyaBukuKIA(lang: String) =
        if (lang == "id") "Punya Buku KIA" else "Has Maternal and Child Health Book"

    fun tidakPunyaBukuKIA(lang: String) =
        if (lang == "id") "Tidak Punya" else "Does Not Have One"

    fun jkn(lang: String) =
        if (lang == "id") "Kepemilikan JKN/JAMHESDA/BPJS" else "Enrollment in JKN/JAMHESDA/BPJS"

    fun punya(lang: String) =
        if (lang == "id") "Punya" else "Has"

    fun tidakPunya(lang: String) =
        if (lang == "id") "Tidak Punya" else "Does Not Have"

    fun riwayatkelahiran(lang: String) =
        if (lang == "id") "Riwayat Kelahiran (**Hanya Diisi Oleh Ibu yang Telah Memiliki Anak Sebelumnya)" else "Birth Record (**To Be Completed Only by Mothers Who Have Had Children Before)"

    fun bayiCukupUmur(lang: String) =
        if (lang == "id") "Bayi Lahir Cukup Umur (≥37 Minggu)" else "Full-term Birth (≥37 Weeks)"

    fun bayiPrematur(lang: String) =
        if (lang == "id") "Bayi lahir Prematur (<37 Minggu)" else "Preterm Birth (<37 Weeks)"

    fun lanjut(lang: String) =
        if (lang == "id") "Lanjut" else "Continue"

    fun datakhususibuhamil(lang: String) =
        if (lang == "id") "🩺 DATA KHUSUS IBU HAMIL" else "🩺 SPECIAL INFORMATION FOR PREGNANT WOMEN"

    fun infeksiIbuHamil(lang: String) =
        if (lang == "id")
            "Penyakit Infeksi Ibu Selama Hamil:\n" +
                    "- Hepatitis B\n" +
                    "- COVID-19 dengan Pneumonia\n" +
                    "- HIV/AIDS\n" +
                    "- TBC\n" +
                    "- IMS"
        else
            "Maternal infections During Pregnancy:\n" +
                    "- Hepatitis B\n" +
                    "- COVID-19 with Pneumonia\n" +
                    "- HIV/AIDS\n" +
                    "- Tuberculosis (TB)\n" +
                    "- STIs"

    fun infeksi0(lang: String) =
        if (lang == "id") "0 Penyakit" else "0 Disease"

    fun infeksi1(lang: String) =
        if (lang == "id") "1 Penyakit" else "1 Disease"

    fun infeksi2(lang: String) =
        if (lang == "id") "2 Penyakit" else "2 Diseases"

    fun infeksi3plus(lang: String) =
        if (lang == "id") "≥3 Penyakit" else "≥3 Diseases"

    fun penyakitTidakMenularHamil(lang: String) =
        if (lang == "id")
            "Penyakit Ibu Saat Hamil Termasuk Penyakit Tidak Menular:\n" +
                    "- Hipertensi\n" +
                    "- Pre-Eklampsia\n" +
                    "- Diabetes Mellitus\n" +
                    "- Penyakit Jantung\n"
        else
            "Non-Communicable Diseases During Pregnancy:\n" +
                    "- Hypertension\n" +
                    "- Pre-eclampsia\n" +
                    "- Diabetes Mellitus\n" +
                    "- Heart Disease\n"

    fun statusgiziibuhamil(lang: String) =
        if (lang == "id") "Status Gizi Ibu Saat Hamil: Kekurangan Energi Kronik (KEK)" else "“Maternal Nutritional Status During Pregnancy: Chronic Energy Deficiency (CED)”"

    fun ya(lang: String) =
        if (lang == "id") "Ya" else "Yes"

    fun tidak(lang: String) =
        if (lang == "id") "Tidak" else "No"

    fun anc(lang: String) =
        if (lang == "id") "Riwayat Pemeriksaan ANC Selama Kehamilan 4-6 Kali (Rutin)" else "4–6 Antenatal Care (ANC) Visits During Pregnancy (Routine)"

    fun tambahdarah(lang: String) =
        if (lang == "id") "Riwayat Ibu Saat Hamil Mendapat Tablet Tambah Darah" else "Mother's History of Taking Iron Supplements During Pregnancy"

    fun lingkarLenganKecil(lang: String) =
        if (lang == "id") "<23 cm" else "<23 cm"

    fun lingkarLenganNormal(lang: String) =
        if (lang == "id") "≥23 cm" else "≥23 cm"

    fun statusberatbadanibu(lang: String) =
        if (lang == "id") "Status Berat Badan Ibu" else "Mother's Weight Status"

    fun bbSebelumHamil(lang: String) =
        if (lang == "id") "BB Sebelum Hamil (kg)" else "Pre-pregnancy Weight (kg)"

    fun bbSaatHamil(lang: String) =
        if (lang == "id") "BB Saat Hamil (kg)" else "Pregnancy Weight (kg)"

    fun tinggiBadan(lang: String) =
        if (lang == "id") "Tinggi Badan (cm)" else "Height (cm)"

    fun kategori(lang: String) =
        if (lang == "id") "Kategori" else "Category"

    fun sanitasi(lang: String) =
        if (lang == "id") "Kondisi Sanitasi Lingkungan" else "Environmental Sanitation Conditions"

    fun sanitasiBaik(lang: String) =
        if (lang == "id")
            "Sanitasi Baik: Memiliki jamban pribadi yang bersih, akses air bersih yang aman dan teratur, lingkungan sangat bersih dengan fasilitas pembuangan sampah yang teratur, udara bersih dan bebas polusi, serta edukasi sanitasi diberikan secara rutin kepada masyarakat, akses terhadap air minum"
        else
            "Good sanitation: Private clean toilet, safe and regular clean water access, very clean environment with proper waste management, clean and low-pollution air, and regular sanitation education, access to drinking water"

    fun sanitasiCukup(lang: String) =
        if (lang == "id")
            "Sanitasi Cukup: Ada akses terbatas ke sanitasi (misalnya, toilet umum), akses air bersih terbatas atau tidak aman, lingkungan cukup bersih tetapi masih ada sampah, kualitas udara cukup baik dengan sedikit polusi, dan ada edukasi sanitasi terbatas"
        else
            "Moderate sanitation: Limited sanitation access (e.g., public toilets), limited or unsafe clean water access, moderately clean environment with some waste, fairly good air quality with slight pollution, and limited sanitation education"

    fun sanitasiBuruk(lang: String) =
        if (lang == "id")
            "Sanitasi Buruk: Tidak ada akses sanitasi yang layak, tidak ada akses air bersih, lingkungan kotor dengan sampah berserakan, kualitas udara buruk (polusi), dan tidak ada edukasi atau pelatihan sanitasi yang diberikan"
        else
            "Poor sanitation: No proper sanitation access, no clean water access, dirty environment with scattered waste, poor air quality (pollution), and no sanitation education or training"

    fun hitungRisiko(lang: String) =
        if (lang == "id") "Hitung Risiko" else "Calculate Risk"


    // ================= RESULT =================
    fun risikoRendah(lang: String) =
        if (lang == "id") "Risiko Rendah" else "Low Risk"

    fun videohamilRisikoRendahTitle(lang: String) =
        if (lang == "id") "Video Edukasi Ibu Hamil Risiko Rendah" else "Low Risk Pregnancy Education Video"

    fun videohamilRisikoRendahDesc(lang: String) =
        if (lang == "id") "Edukasi untuk Ibu Hamil Risiko Rendah." else "Education for Low-Risk Pregnancy."

    fun risikoSedang(lang: String) =
        if (lang == "id") "Risiko Sedang" else "Medium Risk"

    fun videohamilRisikoSedangTitle(lang: String) =
        if (lang == "id") "Video Edukasi Ibu Hamil Risiko Sedang" else "Medium Risk Pregnancy Education Video"

    fun videohamilRisikoSedangDesc(lang: String) =
        if (lang == "id") "Edukasi untuk Ibu Hamil Risiko Sedang." else "Education for Medium-Risk Pregnancy."

    fun riskHigh(lang: String) =
        if (lang == "id") "Risiko Tinggi" else "High Risk"

    fun videohamilRisikoTinggiTitle(lang: String) =
        if (lang == "id") "Video Edukasi Ibu Hamil Risiko Tinggi" else "High Risk Pregnancy Education Video"

    fun videohamilRisikoTinggiDesc(lang: String) =
        if (lang == "id") "Edukasi untuk Ibu Hamil Risiko Tinggi." else "Education for High-Risk Pregnancy."

    fun videoBalitaRisikoRendahTitle(lang: String) =
        if (lang == "id") "Video Edukasi Balita Risiko Rendah" else "Low Risk Toddler Education Video"

    fun videoBalitaRisikoRendahDesc(lang: String) =
        if (lang == "id") "Edukasi untuk ibu dengan Balita Risiko Rendah." else "Education for Mothers with Low-Risk Toddlers."

    fun videoBalitaRisikoSedangTitle(lang: String) =
        if (lang == "id") "Video Edukasi Balita Risiko Sedang" else "Medium Risk Toddler Education Video"

    fun videoBalitaRisikoSedangDesc(lang: String) =
        if (lang == "id") "Edukasi untuk Ibu dengan Balita Risiko Sedang." else "Education for Mothers with Medium-Risk Toddlers."

    fun videoBalitaRisikoTinggiTitle(lang: String) =
        if (lang == "id") "Video Edukasi Balita Risiko Tinggi" else "High Risk Toddler Education Video"

    fun videoBalitaRisikoTinggiDesc(lang: String) =
        if (lang == "id") "Edukasi untuk Ibu dengan Balita Risiko Tinggi." else "Education For Mothers With High-Risk Toddlers."

    fun hasilPemeriksaanPasien(lang: String) =
        if (lang == "id") "Hasil Pemeriksaan Pasien" else "Patient Examination Results"

    fun statusIbuHamil(lang: String) =
        if (lang == "id") "Status: Ibu Hamil" else "Status: Pregnant Mother"

    fun namaAnak(lang: String) =
        if (lang == "id") "Nama Anak" else "Child Name"

    fun anakKe(lang: String) =
        if (lang == "id") "Anak Ke" else "Child Order"

    fun statusIbuBalita(lang: String) =
        if (lang == "id") "Status: Ibu Balita" else "Status: Mother of Toddler"

    fun hasilRisiko(lang: String) =
        if (lang == "id") "HASIL RISIKO" else "RISK RESULT"

    fun interpretasiKlinis(lang: String) =
        if (lang == "id") "Interpretasi Klinis" else "Clinical Interpretation"

    fun rekomendasiEdukasi(lang: String) =
        if (lang == "id") "📚 Rekomendasi Edukasi" else "📚 Educational Recommendations"

    fun tontonSekarang(lang: String) =
        if (lang == "id") "TONTON SEKARANG" else "WATCH NOW"

    fun selesai(lang: String) =
        if (lang == "id") "Selesai" else "Done"

    // ================= FORM IBU BALITA=================
    fun instrumenSkriningStuntingBalita(lang: String) =
        if (lang == "id") "Instrumen Skrining Risiko Stunting Balita" else "Toddler Stunting Risk Screening Instrument"

    fun dataIbu(lang: String) =
        if (lang == "id") "👩 DATA IBU" else "👩 MOTHER DATA"

    fun dataAnak(lang: String) =
        if (lang == "id") "👶 DATA ANAK" else "👶 CHILD DATA"

    fun usiaBayiBalita(lang: String) =
        if (lang == "id") "Usia Bayi / Balita (Bulan)" else "Infant / Toddler Age (Months)"

    fun jenisKelaminAnak(lang: String) =
        if (lang == "id") "Jenis Kelamin Anak" else "Child Gender"

    fun perempuan(lang: String) =
        if (lang == "id") "Perempuan" else "Female"

    fun lakiLaki(lang: String) =
        if (lang == "id") "Laki-laki" else "Male"

    fun dataKhususBalita(lang: String) =
        if (lang == "id") "🩺 DATA KHUSUS BALITA" else "🩺 TODDLER SPECIAL DATA"

    fun kekSaatHamil(lang: String) =
        if (lang == "id")
            "Saat Hamil Anak Ini, Apakah Ibu Pernah Diberitahu Oleh Petugas Kesehatan Bahwa Ibu Mengalami Kekurangan Gizi Atau Kekurangan Energi Kronik (KEK)?"
        else
            "During This Pregnancy, Has The Mother Ever Been Informed By A Health Worker That She Experienced Malnutrition Or Chronic Energy Deficiency (CED)?"

    fun kunjunganAntenatal(lang: String) =
        if (lang == "id")
            "Saat Hamil Anak Ini, Ibu Melakukan Pemeriksaan Kehamilan Sebanyak 4–6 Kali (Rutin)" else "During This Pregnancy, The Mother Attended Antenatal Check-Ups 4–6 Times (Regular)"

    fun tabletTambahDarah(lang: String) =
        if (lang == "id")
            "Saat Hamil Anak Ini, Ibu Mendapat Tablet Tambah Darah" else "During This Pregnancy, The Mother Received Iron Supplement Tablets"

    fun paparanAsapRokok(lang: String) =
        if (lang == "id")
            "Apakah Ada Anggota Keluarga Yang Merokok Di Dalam Rumah Atau Dekat Bayi/Balita?" else "Is There Any Family Member Who Smokes Inside The House Or Near The Infant/Toddler?"

    fun sanitasiToilet(lang: String) =
        if (lang == "id")
            "1) Apakah Keluarga Memiliki Jamban/Toilet Sendiri Yang Digunakan Sehari-Hari?" else "1) Does The Family Have A Private Toilet Used Daily?"

    fun sanitasiAirBersih(lang: String) =
        if (lang == "id")
            "2) Apakah Keluarga Memiliki Air Bersih Yang Cukup Untuk Minum, Memasak, Dan Mandi Setiap Hari?" else "2) Does The Family Have Sufficient Clean Water For Drinking, Cooking, And Bathing Daily?"

    fun sanitasiLingkungan(lang: String) =
        if (lang == "id")
            "3) Apakah Lingkungan Sekitar Rumah Terlihat Bersih Dan Tidak Berbau?" else "3) Is The Surrounding Environment Clean And Odor-Free?"

    fun sanitasiAirAman(lang: String) =
        if (lang == "id")
            "4) Apakah Keluarga Menggunakan Air Yang Aman Untuk Diminum (Air Matang, Air Isi Ulang, Atau Air Kemasan)?" else "4) Does The Family Use Safe Drinking Water (Boiled Water, Refill Water, Or Bottled Water)?"

    fun pbTbBalita(lang: String) =
        if (lang == "id")
            "PB/TB Bayi/Balita Saat Ini (Cm)" else "Current Infant/Toddler Length/Height (Cm)"

    fun masukkanTinggiBadan(lang: String) =
        if (lang == "id")
            "Masukkan Tinggi/Panjang Badan (Cm)" else "Enter Height/Length (Cm)"

    fun lengkapiDataUsiaDanGender(lang: String) =
        if (lang == "id")
            "Lengkapi Usia (Bulan) Dan Jenis Kelamin Terlebih Dahulu" else "Please Complete Age (Months) And Gender First"

    fun stuntedSevere(lang: String) =
        if (lang == "id")
            "Sangat Pendek (Severely Stunted)" else "Severely Stunted"

    fun stuntedModerate(lang: String) =
        if (lang == "id")
            "Pendek (Stunted)" else "Stunted"

    fun normalGrowth(lang: String) =
        if (lang == "id")
            "Normal" else "Normal"

    fun tallGrowth(lang: String) =
        if (lang == "id")
            "Tinggi" else "Tall"

    fun explanationLow(lang: String) =
        if (lang == "id")
            "Kondisi Pasien Berada Dalam Kategori Stabil Dengan Risiko Minimal." else "Patient Condition Is Stable With Minimal Risk."

    fun explanationMedium(lang: String) =
        if (lang == "id")
            "Diperlukan Pemantauan Rutin Dan Intervensi Preventif." else "Regular Monitoring And Preventive Intervention Are Required."

    fun explanationHigh(lang: String) =
        if (lang == "id")
            "Pasien Berada Pada Risiko Tinggi Dan Membutuhkan Evaluasi Medis Segera." else "Patient Is At High Risk And Requires Immediate Medical Evaluation."

    fun bbBalita(lang: String) =
        if (lang == "id")
            "BB Bayi/Balita Saat Ini (Kg) (Misal: 8.5)" else "Current Infant/Toddler Weight (Kg) (E.G.: 8.5)"

    fun bbSangatKurang(lang: String) =
        if (lang == "id")
            "Berat Badan Sangat Kurang" else "Severely Underweight"

    fun bbKurang(lang: String) =
        if (lang == "id")
            "Berat Badan Kurang" else "Underweight"

    fun bbNormal(lang: String) =
        if (lang == "id")
            "Berat Badan Normal" else "Normal Weight"

    fun bbLebih(lang: String) =
        if (lang == "id")
            "Risiko Berat Badan Lebih" else "Risk Of Overweight"

    fun masukkanBeratBadan(lang: String) =
        if (lang == "id")
            "Masukkan Berat Badan (Kg)" else "Enter Weight (Kg)"

    fun asiEksklusif(lang: String) =
        if (lang == "id")
            "Pemberian ASI Eksklusif" else "Exclusive Breastfeeding"

    fun riwayatBblr(lang: String) =
        if (lang == "id")
            "Riwayat Berat Badan Lahir < 2500 Gram" else "History Of Birth Weight < 2500 Grams"

    fun riwayatPanjangBadanLahir(lang: String) =
        if (lang == "id")
            "Riwayat Panjang Badan Bayi Lahir ≤ 48 Cm" else "History Of Birth Length ≤ 48 Cm"

    fun kenaikanBeratBadanBalita(lang: String) =
        if (lang == "id")
            "Balita Mengalami Kenaikan Berat Badan Per Bulan" else "The Child Experiences Monthly Weight Gain"

    fun timbangBalitaRutin(lang: String) =
        if (lang == "id")
            "Balita Ditimbang ≥ 8 Kali Setahun (Rutin)" else "The Child Is Weighed ≥ 8 Times Per Year (Regularly)"

    fun ukurTinggiBalita(lang: String) =
        if (lang == "id")
            "Balita Diukur Panjang/TB ≥ 2 Kali Setahun (Rutin)" else "The Child's Length/Height Is Measured ≥ 2 Times Per Year (Regularly)"

    fun imunisasiLengkap(lang: String) =
        if (lang == "id")
            "Bayi Menerima Imunisasi Dasar Lengkap" else "The Infant Has Received Complete Basic Immunization"

    fun vitaminA(lang: String) =
        if (lang == "id")
            "Balita Menerima Vitamin A Sesuai Umur" else "The Child Receives Vitamin A According To Age"

    fun riwayatIspa(lang: String) =
        if (lang == "id")
            "Riwayat Balita Menderita ISPA Dalam 3 Bulan Terakhir" else "History Of Acute Respiratory Infection (ARI) In The Last 3 Months"

    fun riwayatPneumonia(lang: String) =
        if (lang == "id")
            "Riwayat Balita Menderita Pneumonia (Penyakit Paru)" else "History Of Pneumonia (Lung Infection)"

    fun riwayatDiare(lang: String) =
        if (lang == "id")
            "Pernah Diare Dalam 3 Bulan Terakhir" else "History Of Diarrhea In The Last 3 Months"

    fun riwayatRawatInap(lang: String) =
        if (lang == "id")
            "Riwayat Balita Pernah Rawat Inap Di Rumah Sakit/Puskesmas" else "History Of Hospitalization At A Hospital Or Community Health Center"

    fun kebiasaanTidurBalita(lang: String) =
        if (lang == "id")
            "Balita Memiliki Kebiasaan Tidur Larut Malam" else "The Child Has A Habit Of Sleeping Late At Night"

    fun menuHarianBalita(lang: String) =
        if (lang == "id")
            "Balita Mengkonsumsi Menu Harian Terdiri Dari:\n" +
                    "1.\tKarbohidrat (Nasi, Kentang, Ubi, Roti)\n" +
                    "2.\tProtein Hewani (Ikan, Telur, Daging, Ayam)"
        else
            "The Child's Daily Diet Consists Of:\n" +
                    "1.\tCarbohydrates (Rice, Potatoes, Sweet Potatoes, Bread)\n" +
                    "2.\tAnimal Protein (Fish, Eggs, Meat, Chicken)"

    fun forgotTitle(lang: String) =
        if (lang == "id")
            "Lupa Password"
        else
            "Forgot Password"

    fun forgotDescription(lang: String) =
        if (lang == "id")
            "Masukkan email yang terdaftar pada akun SIRANTING untuk menerima tautan reset password."
        else
            "Enter the email registered to your SIRANTING account to receive a password reset link."

    fun resetPassword(lang: String) =
        if (lang == "id")
            "Reset Password"
        else
            "Reset Password"

    fun email(lang: String) =
        if (lang == "id")
            "Email"
        else
            "Email"

    fun emailPlaceholder(lang: String) =
        if (lang == "id")
            "contoh@gmail.com"
        else
            "example@gmail.com"

    fun send(lang: String) =
        if (lang == "id")
            "KIRIM"
        else
            "SEND"

    fun backToLogin(lang: String) =
        if (lang == "id")
            "KEMBALI KE LOGIN"
        else
            "BACK TO LOGIN"

    fun emptyEmail(lang: String) =
        if (lang == "id")
            "Email tidak boleh kosong."
        else
            "Email cannot be empty."

    fun resetSuccess(lang: String) =
        if (lang == "id")
            "Email reset password telah dikirim. Silakan periksa Inbox atau folder Spam pada email Anda."
        else
            "Password reset email has been sent. Please check your Inbox or Spam folder."

    fun resetFailed(lang: String) =
        if (lang == "id")
            "Gagal mengirim email."
        else
            "Failed to send email."

    fun medicalSystem(lang: String) =
        if (lang == "id")
            "SIRANTING Medical Screening System"
        else
            "SIRANTING Medical Screening System"

    // ================= REGISTER =================

    fun registerTitle(lang: String) =
        if (lang == "id") "Buat Akun" else "Create Account"

    fun registerDesc(lang: String) =
        if (lang == "id")
            "Daftarkan akun untuk mengakses layanan skrining risiko stunting pada ibu hamil dan balita."
        else
            "Create an account to access stunting risk screening services for mothers and toddlers."

    fun accountInfo(lang: String) =
        if (lang == "id") "Informasi Akun" else "Account Information"

    fun fullName(lang: String) =
        if (lang == "id") "Nama Lengkap" else "Full Name"

    fun phoneNumber(lang: String) =
        if (lang == "id") "Nomor HP" else "Phone Number"

    fun password(lang: String) =
        if (lang == "id") "Kata Sandi" else "Password"

    fun confirmPassword(lang: String) =
        if (lang == "id") "Konfirmasi Password" else "Confirm Password"

    fun registerButton(lang: String) =
        if (lang == "id") "DAFTAR SEKARANG" else "REGISTER NOW"

    fun emptyFieldError(lang: String) =
        if (lang == "id")
            "Semua field wajib diisi"
        else
            "All fields are required"

    fun passwordMismatch(lang: String) =
        if (lang == "id")
            "Password tidak sama"
        else
            "Passwords do not match"

    fun systemFooter(lang: String) =
        "SIRANTING Medical Screening System"

    // ================= EDUCATION VIDEO =================

    fun videoSirantingBalitaTitle(lang: String) =
        if (lang == "id")
            "Video Edukasi Aplikasi SIRANTING Ibu dengan Balita"
        else
            "SIRANTING Application Education Video for Mothers with Toddlers"

    fun videoSirantingBalitaDesc(lang: String) =
        if (lang == "id")
            "Bersama Cegah Stunting, Wujudkan Anak Sehat dan Tumbuh Optimal"
        else
            "Together Prevent Stunting, Ensure Healthy and Optimal Child Growth"

    fun videoHamilSedangTitle(lang: String) =
        if (lang == "id")
            "Video Ibu Hamil Risiko Sedang Stunting"
        else
            "Medium Risk Pregnancy Education Video"

    fun videoHamilSedangDesc(lang: String) =
        if (lang == "id")
            "Langkah bijak bagi ibu hamil dengan risiko sedang untuk menjaga kehamilan tetap sehat dan mencegah stunting sejak dalam kandungan."
        else
            "Wise steps for medium-risk pregnant women to maintain a healthy pregnancy and prevent stunting from early pregnancy"

    fun videoBalitaSedangTitle(lang: String) =
        if (lang == "id")
            "Video Ibu dengan Balita Risiko Sedang Stunting"
        else
            "Medium Risk Toddler Education Video"

    fun videoBalitaSedangDesc(lang: String) =
        if (lang == "id")
            "Panduan praktis bagi ibu untuk memperbaiki pertumbuhan balita dengan risiko sedang stunting melalui edukasi gizi dan pemantauan rutin di Posyandu."
        else
            "Practical guidance for mothers to improve toddler growth with medium stunting risk through nutrition education and routine monitoring"

    fun videoApaItuStuntingTitle(lang: String) =
        if (lang == "id")
            "Apa Itu Stunting?"
        else
            "What is Stunting?"

    fun videoApaItuStuntingDesc(lang: String) =
        if (lang == "id")
            "Memahami pengertian, penyebab, dampak, dan pentingnya pencegahan stunting sejak dini."
        else
            "Understanding definition, causes, impacts, and importance of early stunting prevention"

    fun videoPencegahanStuntingTitle(lang: String) =
        if (lang == "id")
            "Pencegahan Stunting"
        else
            "Stunting Prevention"

    fun videoPencegahanStuntingDesc(lang: String) =
        if (lang == "id")
            "Pelajari langkah sederhana untuk mencegah stunting melalui gizi, sanitasi, dan pola asuh yang tepat."
        else
            "Learn simple steps to prevent stunting through nutrition, sanitation, and proper parenting"

    fun videoKesehatanIbuBalitaTitle(lang: String) =
        if (lang == "id")
            "Kesehatan Ibu dan Balita"
        else
            "Maternal and Child Health"

    fun videoKesehatanIbuBalitaDesc(lang: String) =
        if (lang == "id")
            "Edukasi mengenai kesehatan ibu hamil dan tumbuh kembang balita untuk mendukung generasi sehat."
        else
            "Education about maternal health and child development for a healthy generation"

    fun videoHamilTinggiTitle(lang: String) =
        if (lang == "id")
            "Video Ibu Hamil Risiko Tinggi Stunting"
        else
            "High Risk Pregnancy Education Video"

    fun videoHamilTinggiDesc(lang: String) =
        if (lang == "id")
            "Panduan komprehensif bagi ibu hamil dengan risiko tinggi untuk menjaga kesehatan kehamilan, memastikan asupan gizi optimal, dan melakukan pencegahan stunting sedini mungkin dari dalam kandungan."
        else
            "A comprehensive guide for high-risk pregnant women to maintain a healthy pregnancy, ensure optimal nutritional intake, and prevent stunting as early as possible from the womb."

    fun videoBalitaTinggiTitle(lang: String) =
        if (lang == "id")
            "Video Ibu dengan Balita Risiko Tinggi Stunting"
        else
            "High Risk Toddler Education Video"

    fun videoBalitaTinggiDesc(lang: String) =
        if (lang == "id")
            "Panduan intensif bagi ibu untuk memperbaiki tumbuh kembang balita dengan risiko tinggi stunting melalui perbaikan gizi dan pemantauan medis secara rutin."
        else
            "An intensive guide for mothers to improve the growth and development of toddlers at high risk of stunting through nutritional improvement and routine medical monitoring."

    fun videoSirantingHamilBalitaRendah(lang: String) =
        if (lang == "id")
            "Panduan Kesehatan Risiko Rendah"
        else
            "Low-Risk Health Guide"

    fun videoSirantingHamilBalitaRendahDesc(lang: String) =
        if (lang == "id")
            "Video ini menjelaskan langkah-langkah pencegahan stunting bagi Ibu dan Balita dengan kategori risiko rendah. Tetap jaga pola makan bergizi seimbang, rutin memantau pertumbuhan di Posyandu, dan berikan stimulasi yang cukup untuk mendukung tumbuh kembang optimal anak."
        else
            "This video explains stunting prevention steps for mothers and toddlers in the low-risk category. Maintain a balanced nutritious diet, monitor growth regularly at the health center (Posyandu), and provide adequate stimulation to support the child's optimal growth and development."
}