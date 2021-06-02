package com.b21_cap0183.paddycare.core.utils

import com.b21_cap0183.paddycare.R
import com.b21_cap0183.paddycare.core.data.source.local.entity.DiseaseEntity

object DataDummy {

    fun generateDiseases(): List<DiseaseEntity> {

        val diseases = ArrayList<DiseaseEntity>()

        diseases.add(
            DiseaseEntity(
                1,
                "Leaf Blast",
                diseaseDescription = """
                    Spots on the leaf midrib.
                    Rhombus-shaped spots on leaves and leaf midribs.
                    Gray or white spots and brown/reddish brown edges.
                    Brown spots on panicles, dead leaves, and dry leaf midrib.
                    Empty panicles.
                """.trimIndent() ,
                diseaseSolution = """
                    Use resistant varieties according to the distribution of races in the local area.
                    Use healthy seeds.
                    Avoid the use of nitrogen fertilizers above the recommended dose.
                    Avoid planting rice with the same variety continuously throughout the year.
                    Environmental sanitation must be intensive because alternative hosts for pathogens can be grasses.
                    Avoid planting rice late from nearby farmers' crops.
                    Early control with seed treatment is highly recommended to save the nursery until the age of 30 days after sowing.
                    Systemic fungicide spraying should be done twice at the maximum tillering stage and at the beginning of flowering to prevent leaf blast and neck blast, especially in endemic areas.
                    Avoid close spacing (spread directly).
                    Use of compost as a source of organic matter.
                """.trimIndent(),
                R.drawable.paddy1
            )
        )

        diseases.add(
            DiseaseEntity(
                2,
                "Brown Spot",
                "",
                "",
                R.drawable.paddy2
            )
        )

        diseases.add(
            DiseaseEntity(
                3,
                "Rice Hispa",
                "",
                "",
                R.drawable.paddy4
            )
        )

        diseases.add(
            DiseaseEntity(
                4,
                "Disease 4",
                "",
                "",
                R.drawable.paddy6
            )
        )

        return diseases

    }
}